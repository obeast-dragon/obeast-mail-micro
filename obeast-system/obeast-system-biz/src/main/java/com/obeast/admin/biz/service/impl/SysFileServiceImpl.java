package com.obeast.admin.biz.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.amazonaws.services.s3.model.S3Object;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.admin.api.entity.SysFile;
import com.obeast.admin.biz.mapper.SysFileMapper;
import com.obeast.admin.biz.service.SysFileService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.oss.config.OssProperties;
import com.obeast.common.oss.template.OssTemplate;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wxl
 * Date 2023/5/15 11:56
 * @version 1.0
 * Description: 文件管理
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements SysFileService {

	private final OssProperties ossProperties;

	private final OssTemplate ossTemplate;

	/**
	 * 上传文件
	 * @param file file
	 */
	@Override
	public CommonResult<?> uploadFile(MultipartFile file) {
		String fileName = IdUtil.simpleUUID() + StrUtil.DOT + FileUtil.extName(file.getOriginalFilename());
		Map<String, String> resultMap = new HashMap<>(4);
		resultMap.put("bucketName", ossProperties.getBucketName());
		resultMap.put("fileName", fileName);
		resultMap.put("url", String.format("/admin/sysFile/online/%s/%s", ossProperties.getBucketName(), fileName));

		try {
			ossTemplate.putObject(ossProperties.getBucketName(), fileName,file.getInputStream(), file.getContentType());
			// 文件管理数据记录,收集管理追踪文件
			fileLog(file, fileName);
		}
		catch (Exception e) {
			log.error("上传失败", e);
			return CommonResult.error(e.getLocalizedMessage());
		}
		return CommonResult.success(resultMap);
	}

	/**
	 * 读取文件
	 * @param bucket bucket
	 * @param fileName fileName
	 * @param response response
	 */
	@Override
	public void getFile(String bucket, String fileName, HttpServletResponse response) {
		try (S3Object s3Object = ossTemplate.getObject(bucket, fileName)) {
			response.setContentType("application/octet-stream; charset=UTF-8");
			IoUtil.copy(s3Object.getObjectContent(), response.getOutputStream());
		}
		catch (Exception e) {
			log.error("文件读取异常: {}", e.getLocalizedMessage());
		}
	}

	/**
	 * 删除文件
	 * @param id id
	 */
	@Override
	@SneakyThrows
	@Transactional(rollbackFor = Exception.class)
	public Boolean deleteFile(Long id) {
		SysFile file = this.getById(id);
		ossTemplate.removeObject(ossProperties.getBucketName(), file.getFileName());
		return this.removeById(id);
	}

	/**
	 * 文件管理数据记录,收集管理追踪文件
	 * @param file 上传文件格式
	 * @param fileName 文件名
	 */
	private void fileLog(MultipartFile file, String fileName) {
		SysFile sysFile = new SysFile();
		sysFile.setFileName(fileName);
		sysFile.setOriginal(file.getOriginalFilename());
		sysFile.setFileSize(file.getSize());
		sysFile.setType(FileUtil.extName(file.getOriginalFilename()));
		sysFile.setBucketName(ossProperties.getBucketName());
		this.save(sysFile);
	}

	@Override
	public String onlineFile(String bucket, String fileName) {
		return ossTemplate.getObjectURL(bucket, fileName);
	}

	/**
	 * 默认获取文件的在线地址
	 * @param bucket bucket
	 * @param fileName fileName
	 */
	@Override
	public String onlineFileExpires(String bucket, String fileName) {
		return ossTemplate.getObjectURL(bucket, fileName, Duration.of(7, ChronoUnit.DAYS));
	}

}

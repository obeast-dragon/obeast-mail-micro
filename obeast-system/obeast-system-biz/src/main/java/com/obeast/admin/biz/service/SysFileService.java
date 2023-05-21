package com.obeast.admin.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.entity.SysFile;
import com.obeast.common.core.base.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author wxl
 * Date 2023/4/10 0:23
 * @version 1.0
 * Description: 文件管理
 */
public interface SysFileService extends IService<SysFile> {

	/**
	 * 上传文件
	 * @param file file
	 */
	Object uploadFile(MultipartFile file);

	/**
	 * Description: 上传文件
	 * @author wxl
	 * Date: 2023/5/21 17:11
	 * @param files files
	 * @return com.obeast.common.core.base.CommonResult<?>
	 */
	CommonResult<?> uploadFiles(MultipartFile[] files);

	/**
	 * 读取文件
	 * @param bucket 桶名称
	 * @param fileName 文件名称
	 * @param response 输出流
	 */
	void getFile(String bucket, String fileName, HttpServletResponse response);

	/**
	 * 删除文件
	 * @param id id
	 */
	Boolean deleteFile(Long id);

	/**
	 * 获取外网访问地址
	 * @param bucket bucket
	 * @param fileName fileName
	 */
	String onlineFileExpires(String bucket, String fileName);

	/**
	 * Description: 获取外网访问地址
	 * @author wxl
	 * Date: 2023/5/15 23:11
	 * @param bucket bucket
	 * @param fileName fileName
	 * @return java.lang.String
	 */
	String onlineFile(String bucket, String fileName);
}

package com.obeast.admin.biz.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.admin.api.entity.SysFile;
import com.obeast.admin.biz.service.SysFileService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.log.annotation.SysLogFlag;
import com.obeast.common.security.annotation.Inner;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wxl
 * Date \ 11:44
 * @version 1.0
 * Description: 文件管理
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysFile")
@Tag(name = "文件管理模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class SysFileController {

    private final SysFileService sysFileService;

    /**
     * 分页查询
     *
     * @param page    分页对象
     * @param sysFile 文件管理
     */
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/page")
    public CommonResult<IPage<SysFile>> getSysFilePage(Page<SysFile> page, SysFile sysFile) {
        return CommonResult.success(sysFileService.page(page, Wrappers.<SysFile>lambdaQuery()
                .like(StrUtil.isNotBlank(sysFile.getFileName()), SysFile::getFileName, sysFile.getFileName())));
    }

    /**
     * 通过id删除文件管理
     *
     * @param id id
     * @return R
     */
    @Operation(summary = "通过id删除文件管理", description = "通过id删除文件管理")
    @SysLogFlag("删除文件管理")
    @DeleteMapping("/{id:\\d+}")
    @PreAuthorize("@pms.hasPermission('sys_file_del')")
    public CommonResult<Boolean> removeById(@PathVariable Long id) {
        return CommonResult.success(sysFileService.deleteFile(id));
    }

    /**
     * 上传文件 文件名采用uuid,避免原始文件名中带"-"符号导致下载的时候解析出现异常
     *
     * @param file 资源
     * @return CommonResult
     */
    @PostMapping(value = "/upload")
    public CommonResult<?> upload(@RequestPart("file") MultipartFile file) {
        return CommonResult.success(sysFileService.uploadFile(file));
    }

    @PostMapping(value = "/uploads")
    public CommonResult<?> uploads(@RequestPart("files") MultipartFile[] files) {
		return sysFileService.uploadFiles(files);
    }

    /**
     * 获取文件
     *
     * @param bucket   桶名称
     * @param fileName 文件空间/名称
     * @param response response
     */
    @Inner(false)
    @GetMapping("/{bucket}/{fileName}")
    public void file(@PathVariable String bucket, @PathVariable String fileName, HttpServletResponse response) {
        sysFileService.getFile(bucket, fileName, response);
    }

    /**
     * 获取本地（resources）文件
     *
     * @param fileName 文件名称
     * @param response 本地文件
     */
    @SneakyThrows
    @GetMapping("/local/{fileName}")
    public void localFile(@PathVariable String fileName, HttpServletResponse response) {
        ClassPathResource resource = new ClassPathResource("file/" + fileName);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IoUtil.copy(resource.getInputStream(), response.getOutputStream());
    }

    /**
     * 获取文件外网的访问地址（过期时间）
     *
     * @param bucket   bucket
     * @param fileName fileName
     */
    @Inner(false)
    @Operation(summary = "获取文件url(过期时间)", description = "获取文件url")
    @GetMapping("/online/expires/{bucket}/{fileName}")
    public CommonResult<String> onlineFileExpires(@PathVariable String bucket, @PathVariable String fileName) {
        return CommonResult.success(sysFileService.onlineFileExpires(bucket, fileName));
    }


    /**
     * 获取文件外网的访问地址（过期时间）
     *
     * @param bucket   bucket
     * @param fileName fileName
     */
    @Inner(false)
    @Operation(summary = "获取文件url", description = "获取文件url")
    @GetMapping("/online/{bucket}/{fileName}")
    public CommonResult<String> onlineFile(@PathVariable String bucket, @PathVariable String fileName) {
        return CommonResult.success(sysFileService.onlineFile(bucket, fileName));
    }

}

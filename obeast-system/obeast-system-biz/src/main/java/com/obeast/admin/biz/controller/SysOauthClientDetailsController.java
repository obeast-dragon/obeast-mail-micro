package com.obeast.admin.biz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.admin.api.entity.SysOauthClientDetails;
import com.obeast.admin.biz.service.SysOauthClientDetailsService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.log.annotation.SysLogFlag;
import com.obeast.common.security.annotation.Inner;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:16
 * @version 1.0
 * Description: 前端控制器
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
@Tag(name = "客户端管理模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class SysOauthClientDetailsController {

	private final SysOauthClientDetailsService sysOauthClientDetailsService;

	/**
	 * 通过ID查询
	 * @param clientId 客户端id
	 * @return SysOauthClientDetails
	 */
	@GetMapping("/{clientId}")
	public CommonResult<List<SysOauthClientDetails>> getByClientId(@PathVariable String clientId) {
		return CommonResult.success(sysOauthClientDetailsService
			.list(Wrappers.<SysOauthClientDetails>lambdaQuery().eq(SysOauthClientDetails::getClientId, clientId)));
	}

	/**
	 * 简单分页查询
	 * @param page 分页对象
	 * @param sysOauthClientDetails 系统终端
	 */
	@GetMapping("/page")
	public CommonResult<IPage<SysOauthClientDetails>> getOauthClientDetailsPage(Page<SysOauthClientDetails> page,
			SysOauthClientDetails sysOauthClientDetails) {
		return CommonResult.success(sysOauthClientDetailsService.page(page, Wrappers.emptyWrapper()));
	}

	/**
	 * 添加
	 * @param sysOauthClientDetails 实体
	 * @return success/false
	 */
	@SysLogFlag("添加终端")
	@PostMapping("/add")
	@PreAuthorize("@pms.hasPermission('sys_client_add')")
	public CommonResult<Boolean> add(@Valid @RequestBody SysOauthClientDetails sysOauthClientDetails) {
		return CommonResult.success(sysOauthClientDetailsService.saveSysOauthClientDetails(sysOauthClientDetails));
	}

	/**
	 * 删除
	 * @param id ID
	 * @return success/false
	 */
	@SysLogFlag("删除终端")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('sys_client_del')")
	public CommonResult<Boolean> removeById(@PathVariable String id) {
		return CommonResult.success(sysOauthClientDetailsService.removeClientDetailsById(id));
	}

	/**
	 * 编辑
	 * @param sysOauthClientDetails 实体
	 * @return success/false
	 */
	@SysLogFlag("编辑终端")
	@PutMapping("/update")
	@PreAuthorize("@pms.hasPermission('sys_client_edit')")
	public CommonResult<Boolean> update(@Valid @RequestBody SysOauthClientDetails sysOauthClientDetails) {
		return CommonResult.success(sysOauthClientDetailsService.updateClientDetailsById(sysOauthClientDetails));
	}

	@SysLogFlag("清除终端缓存")
	@DeleteMapping("/cache")
	@PreAuthorize("@pms.hasPermission('sys_client_del')")
	public CommonResult<?> clearClientCache() {
		sysOauthClientDetailsService.clearClientCache();
		return CommonResult.success();
	}

	@Inner
	@GetMapping("/getClientDetailsById/{clientId}")
	public CommonResult<?> getClientDetailsById(@PathVariable String clientId) {
		return CommonResult.success(sysOauthClientDetailsService.getOne(
				Wrappers.<SysOauthClientDetails>lambdaQuery().eq(SysOauthClientDetails::getClientId, clientId), false));
	}

}

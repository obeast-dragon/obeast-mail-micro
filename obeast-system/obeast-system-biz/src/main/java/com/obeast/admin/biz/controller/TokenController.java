package com.obeast.admin.biz.controller;

import com.obeast.admin.api.feign.RemoteTokenService;
import com.obeast.common.core.base.CommonResult;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author wxl
 * Date 2023/4/10 0:17
 * @version 1.0
 * Description: getTokenPage 管理
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/token")
@Tag(name = "令牌管理模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class TokenController {

	private final RemoteTokenService remoteTokenService;

	/**
	 * 分页token 信息
	 * @param size size
	 * @param current current
	 * @return token集合
	 */
	@GetMapping("/page")
	public CommonResult<?> token(
			@RequestParam(value = "size", required = false) Integer size,
			@RequestParam(value = "current", required = false) Integer current
	) {
		return remoteTokenService.getTokenPage(size, current);
	}

	/**
	 * 删除
	 * @param id ID
	 * @return success/false
	 */
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('sys_token_del')")
	public CommonResult<Boolean> delete(@PathVariable String id) {
		return remoteTokenService.removeToken(id);
	}

}

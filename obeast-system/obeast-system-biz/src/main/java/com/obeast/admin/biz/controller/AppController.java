package com.obeast.admin.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.admin.api.dto.AppSmsDTO;
import com.obeast.admin.api.dto.UserInfo;
import com.obeast.admin.api.entity.SysUser;
import com.obeast.admin.biz.service.AppService;
import com.obeast.admin.biz.service.SysUserService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.exception.ErrorCodes;
import com.obeast.common.core.utils.MsgUtil;
import com.obeast.common.security.annotation.Inner;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author wxl
 * Date 2023/4/10 0:15
 * @version 1.0
 * Description: 移动端登录
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app")
@Tag(name = "移动端登录模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class AppController {

	private final AppService appService;

	private final SysUserService userService;

	/**
	 * 发送手机验证码
	 * @param sms 请求手机对象
	 * @return code
	 */
	@Inner(value = false)
	@PostMapping("/sms")
	public CommonResult<Boolean> sendSmsCode(@Valid @RequestBody AppSmsDTO sms) {
		return appService.sendSmsCode(sms);
	}

	/**
	 * 获取指定用户全部信息
	 * @param phone 手机号
	 * @return 用户信息
	 */
	@Inner
	@GetMapping("/info/{phone}")
	public CommonResult<UserInfo> infoByMobile(@PathVariable String phone) {
		SysUser user = userService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getPhone, phone));
		if (user == null) {
			return CommonResult.error(MsgUtil.getMessage(ErrorCodes.SYS_USER_USERINFO_EMPTY, phone));
		}
		return CommonResult.success(userService.getUserInfo(user));
	}

}

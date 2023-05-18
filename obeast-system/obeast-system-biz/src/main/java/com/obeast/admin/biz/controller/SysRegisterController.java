package com.obeast.admin.biz.controller;


import com.obeast.admin.api.dto.UserDTO;
import com.obeast.admin.biz.service.SysUserService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.log.annotation.SysLogFlag;
import com.obeast.common.security.annotation.Inner;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxl
 * Date 2023/4/10 0:17
 * @version 1.0
 * Description: 客户端注册功能 register.user = false
 */
@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@ConditionalOnProperty(name = "register.user", matchIfMissing = true)
@Tag(name = "客户端注册功能")
public class SysRegisterController {

	private final SysUserService userService;

	/**
	 * 注册用户
	 * @param userDto 用户信息
	 * @return success/false
	 */
	@Inner(value = false)
	@SysLogFlag("注册用户")
	@PostMapping("/user")
	public CommonResult<Boolean> registerUser(@RequestBody UserDTO userDto) {
		return userService.registerUser(userDto);
	}

}

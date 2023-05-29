package com.obeast.admin.biz.controller;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.obeast.common.core.base.CommonResult;
import com.obeast.admin.api.dto.UserDTO;
import com.obeast.admin.api.dto.UserInfo;
import com.obeast.admin.api.entity.SysUser;
import com.obeast.admin.api.vo.UserInfoVO;
import com.obeast.admin.api.vo.UserVO;
import com.obeast.admin.biz.service.SysUserService;
import com.obeast.common.core.exception.ErrorCodes;
import com.obeast.common.core.utils.MsgUtil;
import com.obeast.common.log.annotation.SysLogFlag;
import com.obeast.common.security.annotation.Inner;
import com.obeast.common.security.util.SecurityUtils;
import com.obeast.common.xss.core.XssCleanIgnore;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * @author wxl
 * Date 2023/4/10 0:17
 * @version 1.0
 * Description: 用户管理模块
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "用户管理模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class SysUserController {

	private final SysUserService userService;


	/**
	 * 获取当前用户全部信息
	 * @return 用户信息
	 */
	@GetMapping(value = { "/info" })
	public CommonResult<UserInfoVO> info() {
		String username = SecurityUtils.getUser().getUsername();
		SysUser user = userService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
		if (user == null) {
			return CommonResult.error(MsgUtil.getMessage(ErrorCodes.SYS_USER_QUERY_ERROR));
		}
		UserInfo userInfo = userService.getUserInfo(user);
		UserInfoVO vo = new UserInfoVO();
		vo.setSysUser(userInfo.getSysUser());
		vo.setRoles(userInfo.getRoles());
		vo.setPermissions(userInfo.getPermissions());
		return CommonResult.success(vo);
	}

	/**
	 * 获取指定用户全部信息
	 * @return 用户信息
	 */
	@Inner
	@GetMapping("/info/{username}")
	public CommonResult<UserInfo> info(@PathVariable String username) {
		SysUser user = userService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
		if (user == null) {
			return CommonResult.error(MsgUtil.getMessage(ErrorCodes.SYS_USER_USERINFO_EMPTY, username));
		}
		return CommonResult.success(userService.getUserInfo(user));
	}

	@GetMapping("/listObj")
	public CommonResult<List<JSONObject>> listUserObj () {
		return CommonResult.success(userService.listUserObj());
	}

	/**
	 * 根据部门id，查询对应的用户 id 集合
	 * @param deptIds 部门id 集合
	 * @return 用户 id 集合
	 */
	@Inner
	@GetMapping("/ids")
	public CommonResult<List<Long>> listUserIdByDeptIds(@RequestParam("deptIds") Set<Long> deptIds) {
		return CommonResult.success(userService.listUserIdByDeptIds(deptIds));
	}

	/**
	 * 通过ID查询用户信息
	 * @param id ID
	 * @return 用户信息
	 */
	@GetMapping("/{id:\\d+}")
	public CommonResult<UserVO> user(@PathVariable Long id) {
		return CommonResult.success(userService.getUserVoById(id));
	}

	/**
	 * 判断用户是否存在
	 * @param userDTO 查询条件
	 * @return CommonResult
	 */
	@Inner(false)
	@GetMapping("/check/exist")
	public CommonResult<Boolean> isExist(UserDTO userDTO) {
		List<SysUser> sysUserList = userService.list(new QueryWrapper<>(userDTO));
		if (CollUtil.isNotEmpty(sysUserList)) {
			return CommonResult.success(Boolean.TRUE, MsgUtil.getMessage(ErrorCodes.SYS_USER_EXISTING));
		}
		return CommonResult.success(Boolean.FALSE);
	}

	/**
	 * 删除用户信息
	 * @param id ID
	 * @return CommonResult
	 */
	@SysLogFlag("删除用户信息")
	@DeleteMapping("/{id:\\d+}")
	@PreAuthorize("@pms.hasPermission('sys_user_del')")
	public CommonResult<Boolean> userDel(@PathVariable Long id) {
		SysUser sysUser = userService.getById(id);
		return CommonResult.success(userService.removeUserById(sysUser));
	}

	/**
	 * 添加用户
	 * @param userDto 用户信息
	 * @return success/false
	 */
	@SysLogFlag("添加用户")
	@PostMapping("/add")
	@XssCleanIgnore({ "password" })
	@PreAuthorize("@pms.hasPermission('sys_user_add')")
	public CommonResult<Boolean> user(@RequestBody UserDTO userDto) {
		return CommonResult.success(userService.saveUser(userDto));
	}

	/**
	 * 管理员更新用户信息
	 * @param userDto 用户信息
	 * @return CommonResult
	 */
	@SysLogFlag("更新用户信息")
	@PutMapping("/update")
	@XssCleanIgnore({ "password" })
	@PreAuthorize("@pms.hasPermission('sys_user_edit')")
	public CommonResult<Boolean> updateUser(@Valid @RequestBody UserDTO userDto) {
		return userService.updateUser(userDto);
	}

	/**
	 * 分页查询用户
	 * @param page 参数集
	 * @param userDTO 查询参数列表
	 * @return 用户集合
	 */
	@GetMapping("/page")
	public CommonResult<IPage<UserVO>> getUserPage(Page<?> page, UserDTO userDTO) {
		return CommonResult.success(userService.getUserWithRolePage(page, userDTO));
	}

	/**
	 * 个人修改个人信息
	 * @param userDto userDto
	 * @return success/false
	 */
	@SysLogFlag("修改个人信息")
	@PutMapping("/edit")
	@XssCleanIgnore({ "password", "newpassword1" })
	public CommonResult<Boolean> updateUserInfo(@Valid @RequestBody UserDTO userDto) {
		userDto.setUsername(SecurityUtils.getUser().getUsername());
		return userService.updateUserInfo(userDto);
	}

	/**
	 * @param username 用户名称
	 * @return 上级部门用户列表
	 */
	@GetMapping("/ancestor/{username}")
	public CommonResult<List<SysUser>> listAncestorUsers(@PathVariable String username) {
		return CommonResult.success(userService.listAncestorUsersByUsername(username));
	}

//	/**
//	 * 导出excel 表格
//	 * @param userDTO 查询条件
//	 * @return
//	 */
//	@ResponseExcel
//	@GetMapping("/export")
//	@PreAuthorize("@pms.hasPermission('sys_user_import_export')")
//	public List<UserExcelVO> export(UserDTO userDTO) {
//		return userService.listUser(userDTO);
//	}
//
//	/**
//	 * 导入用户
//	 * @param excelVOList 用户列表
//	 * @param bindingResult 错误信息列表
//	 * @return CommonResult
//	 */
//	@PostMapping("/import")
//	@PreAuthorize("@pms.hasPermission('sys_user_import_export')")
//	public R importUser(@RequestExcel List<UserExcelVO> excelVOList, BindingResult bindingResult) {
//		return userService.importUser(excelVOList, bindingResult);
//	}

}

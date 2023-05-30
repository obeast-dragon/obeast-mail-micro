package com.obeast.admin.biz.service.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.admin.api.dto.UserDTO;
import com.obeast.admin.api.dto.UserInfo;
import com.obeast.admin.api.entity.*;
import com.obeast.admin.api.utils.ParamResolver;
import com.obeast.admin.api.vo.UserExcelVO;
import com.obeast.admin.api.vo.UserVO;
import com.obeast.admin.biz.mapper.*;
import com.obeast.admin.biz.service.AppService;
import com.obeast.admin.biz.service.SysMenuService;
import com.obeast.admin.biz.service.SysUserService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.CacheConstants;
import com.obeast.common.core.constant.CommonConstants;
import com.obeast.common.core.constant.enums.MenuTypeEnum;
import com.obeast.common.core.exception.ErrorCodes;
import com.obeast.common.core.utils.MsgUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wxl
 * Date 2023/4/10 0:22
 * @version 1.0
 * Description: SysUserServiceImpl
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

	private final AppService appService;

	private final SysRoleMapper sysRoleMapper;

	private final SysDeptMapper sysDeptMapper;

	private final SysMenuService sysMenuService;

	private final SysPostMapper sysPostMapper;

	private final SysUserRoleMapper sysUserRoleMapper;

	private final SysUserPostMapper sysUserPostMapper;

	/**
	 * 保存用户信息
	 * @param userDto DTO 对象
	 * @return success/fail
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean saveUser(UserDTO userDto) {
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(userDto, sysUser);
		sysUser.setDelFlag(CommonConstants.STATUS_NORMAL);
		sysUser.setPassword(ENCODER.encode(userDto.getPassword()));
		baseMapper.insert(sysUser);
		userDto.getRoleList().stream().map(roleId -> {
			SysUserRole userRole = new SysUserRole();
			userRole.setUserId(sysUser.getUserId());
			userRole.setRoleId(roleId);
			return userRole;
		}).forEach(sysUserRoleMapper::insert);
		// 保存用户岗位信息
		Optional.ofNullable(userDto.getPostList()).ifPresent(posts -> {
			posts.stream().map(postId -> {
				SysUserPost userPost = new SysUserPost();
				userPost.setUserId(sysUser.getUserId());
				userPost.setPostId(postId);
				return userPost;
			}).forEach(sysUserPostMapper::insert);
		});
		return Boolean.TRUE;
	}

	/**
	 * 通过查用户的全部信息
	 * @param sysUser 用户
	 */
	@Override
	public UserInfo getUserInfo(SysUser sysUser) {
		UserInfo userInfo = new UserInfo();
		userInfo.setSysUser(sysUser);
		// 设置角色列表
		List<SysRole> roleList = sysRoleMapper.listRolesByUserId(sysUser.getUserId());
		userInfo.setRoleList(roleList);
		// 设置角色列表 （ID）
		List<Long> roleIds = roleList.stream().map(SysRole::getRoleId).collect(Collectors.toList());
		userInfo.setRoles(ArrayUtil.toArray(roleIds, Long.class));
		// 设置岗位列表
		List<SysPost> postList = sysPostMapper.listPostsByUserId(sysUser.getUserId());
		userInfo.setPostList(postList);
		// 设置权限列表（menu.permission）
		Set<String> permissions = roleIds.stream()
			.map(sysMenuService::findMenuByRoleId)
			.flatMap(Collection::stream)
			.filter(m -> MenuTypeEnum.BUTTON.getType().equals(m.getType()))
			.map(SysMenu::getPermission)
			.filter(StrUtil::isNotBlank)
			.collect(Collectors.toSet());
		userInfo.setPermissions(ArrayUtil.toArray(permissions, String.class));

		return userInfo;
	}

	/**
	 * 分页查询用户信息（含有角色信息）
	 * @param page 分页对象
	 * @param userDTO 参数列表
	 * @return IPage<UserVO>
	 */
	@Override
	public IPage<UserVO> getUserWithRolePage(Page<?> page, UserDTO userDTO) {
		return baseMapper.getUserVosPage(page, userDTO);
	}

	/**
	 * 通过ID查询用户信息
	 * @param id 用户ID
	 * @return 用户信息
	 */
	@Override
	public UserVO getUserVoById(Long id) {
		return baseMapper.getUserVoById(id);
	}

	/**
	 * 删除用户
	 * @param sysUser 用户
	 * @return Boolean
	 */
	@Override
	@CacheEvict(value = CacheConstants.USER_DETAILS, key = "#sysUser.username")
	public Boolean removeUserById(SysUser sysUser) {
		sysUserRoleMapper.deleteByUserId(sysUser.getUserId());
		// 删除用户职位关系
		sysUserPostMapper.delete(Wrappers.<SysUserPost>lambdaQuery().eq(SysUserPost::getUserId, sysUser.getUserId()));
		this.removeById(sysUser.getUserId());
		return Boolean.TRUE;
	}

	@Override
	@CacheEvict(value = CacheConstants.USER_DETAILS, key = "#userDto.username")
	public CommonResult<Boolean> updateUserInfo(UserDTO userDto) {
		UserVO userVO = baseMapper.getUserVoByUsername(userDto.getUsername());

		// 判断手机号是否修改,更新手机号校验验证码
		if (!StrUtil.equals(userVO.getPhone(), userDto.getPhone())) {
			if (!appService.check(userDto.getPhone(), userDto.getCode())) {
				return CommonResult.error(MsgUtil.getMessage(ErrorCodes.SYS_APP_SMS_ERROR));
			}
		}

		// 修改密码逻辑
		SysUser sysUser = new SysUser();
		if (StrUtil.isNotBlank(userDto.getNewpassword1())) {
			Assert.isTrue(ENCODER.matches(userDto.getPassword(), userVO.getPassword()),
					MsgUtil.getMessage(ErrorCodes.SYS_USER_UPDATE_PASSWORDERROR));
			sysUser.setPassword(ENCODER.encode(userDto.getNewpassword1()));
		}
		sysUser.setPhone(userDto.getPhone());
		sysUser.setUserId(userVO.getUserId());
		sysUser.setAvatar(userDto.getAvatar());
		return CommonResult.success(this.updateById(sysUser));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	@CacheEvict(value = CacheConstants.USER_DETAILS, key = "#userDto.username")
	public CommonResult<Boolean> updateUser(UserDTO userDto) {
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(userDto, sysUser);
		sysUser.setUpdateTime(LocalDateTime.now());

		if (StrUtil.isNotBlank(userDto.getPassword())) {
			sysUser.setPassword(ENCODER.encode(userDto.getPassword()));
		}
		this.updateById(sysUser);

		sysUserRoleMapper
			.delete(Wrappers.<SysUserRole>update().lambda().eq(SysUserRole::getUserId, userDto.getUserId()));
		userDto.getRoleList().forEach(roleId -> {
			SysUserRole userRole = new SysUserRole();
			userRole.setUserId(sysUser.getUserId());
			userRole.setRoleId(roleId);
			userRole.insert();
		});
		sysUserPostMapper.delete(Wrappers.<SysUserPost>lambdaQuery().eq(SysUserPost::getUserId, userDto.getUserId()));
		userDto.getPostList().forEach(postId -> {
			SysUserPost userPost = new SysUserPost();
			userPost.setUserId(sysUser.getUserId());
			userPost.setPostId(postId);
			userPost.insert();
		});
		return CommonResult.success();
	}

	/**
	 * 查询上级部门的用户信息
	 * @param username 用户名
	 * @return R
	 */
	@Override
	public List<SysUser> listAncestorUsersByUsername(String username) {
		SysUser sysUser = this.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));

		SysDept sysDept = sysDeptMapper.selectById(sysUser.getDeptId());
		if (sysDept == null) {
			return null;
		}

		Long parentId = sysDept.getParentId();
		return this.list(Wrappers.<SysUser>query().lambda().eq(SysUser::getDeptId, parentId));
	}

	/**
	 * 查询全部的用户
	 * @param userDTO 查询条件
	 * @return list
	 */
	@Override
	public List<UserExcelVO> listUser(UserDTO userDTO) {
		List<UserVO> voList = baseMapper.selectVoList(userDTO);
		// 转换成execl 对象输出
		List<UserExcelVO> userExcelVOList = voList.stream().map(userVO -> {
			UserExcelVO excelVO = new UserExcelVO();
			BeanUtils.copyProperties(userVO, excelVO);
			String roleNameList = userVO.getRoleList()
				.stream()
				.map(SysRole::getRoleName)
				.collect(Collectors.joining(StrUtil.COMMA));
			excelVO.setRoleNameList(roleNameList);
			String postNameList = userVO.getPostList()
				.stream()
				.map(SysPost::getPostName)
				.collect(Collectors.joining(StrUtil.COMMA));
			excelVO.setPostNameList(postNameList);
			return excelVO;
		}).collect(Collectors.toList());
		return userExcelVOList;
	}

	/**
	 * excel 导入用户, 插入正确的 错误的提示行号
	 * @param excelVOList excel 列表数据
	 * @param bindingResult 错误数据
	 * @return ok fail
	 */
	@Override
	public CommonResult importUser(List<UserExcelVO> excelVOList, BindingResult bindingResult) {
//		// 通用校验获取失败的数据
//		List<ErrorMessage> errorMessageList = (List<ErrorMessage>) bindingResult.getTarget();
//
//		// 个性化校验逻辑
//		List<SysUser> userList = this.list();
//		List<SysDept> deptList = sysDeptMapper.selectList(Wrappers.emptyWrapper());
//		List<SysRole> roleList = sysRoleMapper.selectList(Wrappers.emptyWrapper());
//		List<SysPost> postList = sysPostMapper.selectList(Wrappers.emptyWrapper());
//
//		// 执行数据插入操作 组装 UserDto
//		for (UserExcelVO excel : excelVOList) {
//			Set<String> errorMsg = new HashSet<>();
//			// 校验用户名是否存在
//			boolean existUserName = userList.stream()
//				.anyMatch(sysUser -> excel.getUsername().equals(sysUser.getUsername()));
//
//			if (existUserName) {
//				errorMsg.add(MsgUtils.getMessage(ErrorCodes.SYS_USER_USERNAME_EXISTING, excel.getUsername()));
//			}
//
//			// 判断输入的部门名称列表是否合法
//			Optional<SysDept> deptOptional = deptList.stream()
//				.filter(dept -> excel.getDeptName().equals(dept.getName()))
//				.findFirst();
//			if (!deptOptional.isPresent()) {
//				errorMsg.add(MsgUtils.getMessage(ErrorCodes.SYS_DEPT_DEPTNAME_INEXISTENCE, excel.getDeptName()));
//			}
//
//			// 判断输入的角色名称列表是否合法
//			List<String> roleNameList = StrUtil.split(excel.getRoleNameList(), StrUtil.COMMA);
//			List<SysRole> roleCollList = roleList.stream()
//				.filter(role -> roleNameList.stream().anyMatch(name -> role.getRoleName().equals(name)))
//				.collect(Collectors.toList());
//
//			if (roleCollList.size() != roleNameList.size()) {
//				errorMsg.add(MsgUtils.getMessage(ErrorCodes.SYS_ROLE_ROLENAME_INEXISTENCE, excel.getRoleNameList()));
//			}
//
//			// 判断输入的岗位名称列表是否合法
//			List<String> postNameList = StrUtil.split(excel.getPostNameList(), StrUtil.COMMA);
//			List<SysPost> postCollList = postList.stream()
//				.filter(post -> postNameList.stream().anyMatch(name -> post.getPostName().equals(name)))
//				.collect(Collectors.toList());
//
//			if (postCollList.size() != postNameList.size()) {
//				errorMsg.add(MsgUtils.getMessage(ErrorCodes.SYS_POST_POSTNAME_INEXISTENCE, excel.getPostNameList()));
//			}
//
//			// 数据合法情况
//			if (CollUtil.isEmpty(errorMsg)) {
//				insertExcelUser(excel, deptOptional, roleCollList, postCollList);
//			}
//			else {
//				// 数据不合法情况
//				errorMessageList.add(new ErrorMessage(excel.getLineNum(), errorMsg));
//			}
//
//		}
//
//		if (CollUtil.isNotEmpty(errorMessageList)) {
//			return R.failed(errorMessageList);
//		}
		return CommonResult.success();
	}

	@Override
	public List<Long> listUserIdByDeptIds(Set<Long> deptIds) {
		return this.listObjs(
				Wrappers.lambdaQuery(SysUser.class).select(SysUser::getUserId).in(SysUser::getDeptId, deptIds),
				Long.class::cast);
	}

	/**
	 * 插入excel User
	 */
	private void insertExcelUser(UserExcelVO excel, Optional<SysDept> deptOptional, List<SysRole> roleCollList,
			List<SysPost> postCollList) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(excel.getUsername());
		userDTO.setPhone(excel.getPhone());
		// 批量导入初始密码为手机号
		userDTO.setPassword(userDTO.getPhone());
		// 根据部门名称查询部门ID
		userDTO.setDeptId(deptOptional.get().getDeptId());
		// 根据角色名称查询角色ID
		List<Long> roleIdList = roleCollList.stream().map(SysRole::getRoleId).collect(Collectors.toList());
		userDTO.setRoleList(roleIdList);
		List<Long> postIdList = postCollList.stream().map(SysPost::getPostId).collect(Collectors.toList());
		userDTO.setPostList(postIdList);
		// 插入用户
		this.saveUser(userDTO);
	}

	@Override
	public List<JSONObject> listUserObj() {
		return this.list().stream()
				.map(item -> {
					JSONObject object = new JSONObject();
					object.put("userId", item.getUserId());
					object.put("nickName", item.getNickName());
					object.put("username", item.getUsername());
					object.put("phone", item.getPhone());
					return object;
				})
				.toList();
	}

	/**
	 * 注册用户 赋予用户默认角色
	 * @param userDto 用户信息
	 * @return success/false
	 */
	@Override
	public CommonResult<Boolean> registerUser(UserDTO userDto) {
		// 校验验证码
		if (!appService.check(userDto.getPhone(), userDto.getCode())) {
			return CommonResult.error(ErrorCodes.SYS_APP_SMS_ERROR);
		}

		// 判断用户名是否存在
		SysUser sysUser = this.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, userDto.getUsername()));
		if (sysUser != null) {
			return CommonResult.error(MsgUtil.getMessage(ErrorCodes.SYS_USER_USERNAME_EXISTING, userDto.getUsername()));
		}

		// 获取默认角色编码
		String defaultRole = ParamResolver.getStr("USER_DEFAULT_ROLE");
		// 默认角色
		SysRole sysRole = sysRoleMapper
			.selectOne(Wrappers.<SysRole>lambdaQuery().eq(SysRole::getRoleCode, defaultRole));

		if (sysRole == null) {
			return CommonResult.error(MsgUtil.getMessage(ErrorCodes.SYS_PARAM_CONFIG_ERROR, "USER_DEFAULT_ROLE"));
		}

		userDto.setRoleList(Collections.singletonList(sysRole.getRoleId()));
		return CommonResult.success(saveUser(userDto));
	}

}

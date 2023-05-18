package com.obeast.common.security.util;

import cn.hutool.core.util.StrUtil;
import com.obeast.common.core.constant.RoleConstants;
import com.obeast.common.security.service.ObeastUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:05
 * @version 1.0
 * Description: 安全工具类
 */
@UtilityClass
public class SecurityUtils {

	/**
	 * 获取Authentication
	 */
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取用户
	 */
	public ObeastUser getUser(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof ObeastUser) {
			return (ObeastUser) principal;
		}
		return null;
	}

	/**
	 * 获取用户
	 */
	public ObeastUser getUser() {
		Authentication authentication = getAuthentication();
		if (authentication == null) {
			return null;
		}
		return getUser(authentication);
	}

	/**
	 * 获取用户角色信息
	 * @return 角色集合
	 */
	public List<Long> getRoles() {
		Authentication authentication = getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<Long> roleIds = new ArrayList<>();
		authorities.stream()
			.filter(granted -> StrUtil.startWith(granted.getAuthority(), RoleConstants.ROLE))
			.forEach(granted -> {
				String id = StrUtil.removePrefix(granted.getAuthority(), RoleConstants.ROLE);
				roleIds.add(Long.parseLong(id));
			});
		return roleIds;
	}

}

package com.obeast.common.security.service;

import com.obeast.admin.api.dto.UserInfo;
import com.obeast.admin.api.feign.RemoteUserService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.CacheConstants;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author wxl
 * Date 2023/4/10 0:05
 * @version 1.0
 * Description: 用户详细信息
 */
@Slf4j
@Primary
@RequiredArgsConstructor
public class ObeastUserDetailsServiceImpl implements ObeastUserDetailsService {

	private final RemoteUserService remoteUserService;

	private final CacheManager cacheManager;

	/**
	 * 用户名密码登录
	 * @param username 用户名
	 * @return
	 */
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String username) {
		Cache cache = cacheManager.getCache(CacheConstants.USER_DETAILS);
		if (cache != null && cache.get(username) != null) {
			return (ObeastUser) cache.get(username).get();
		}

		CommonResult<UserInfo> result = remoteUserService.info(username);
		UserDetails userDetails = getUserDetails(result);
		if (cache != null) {
			cache.put(username, userDetails);
		}
		return userDetails;
	}

	@Override
	public int getOrder() {
		return Integer.MIN_VALUE;
	}

}

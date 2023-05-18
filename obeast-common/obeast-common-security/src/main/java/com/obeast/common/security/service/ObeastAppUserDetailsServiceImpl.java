package com.obeast.common.security.service;

import com.obeast.admin.api.dto.UserInfo;
import com.obeast.admin.api.feign.RemoteUserService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.CacheConstants;
import com.obeast.common.core.constant.SecurityConstants;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author wxl
 * Date 2023/4/10 0:03
 * @version 1.0
 * Description: 用户详细信息
 */
@Slf4j
@RequiredArgsConstructor
public class ObeastAppUserDetailsServiceImpl implements ObeastUserDetailsService {

	private final RemoteUserService remoteUserService;

	private final CacheManager cacheManager;

	/**
	 * 手机号登录
	 * @param phone 手机号
	 * @return
	 */
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String phone) {
		Cache cache = cacheManager.getCache(CacheConstants.USER_DETAILS);
		if (cache != null && cache.get(phone) != null) {
			return (ObeastUser) cache.get(phone).get();
		}

		CommonResult<UserInfo> result = remoteUserService.infoByMobile(phone);

		UserDetails userDetails = getUserDetails(result);
		if (cache != null) {
			cache.put(phone, userDetails);
		}
		return userDetails;
	}

	/**
	 * check-token 使用
	 * @param obeastUser user
	 * @return
	 */
	@Override
	public UserDetails loadUserByUser(ObeastUser obeastUser) {
		return this.loadUserByUsername(obeastUser.getPhone());
	}

	/**
	 * 是否支持此客户端校验
	 * @param clientId 目标客户端
	 * @return true/false
	 */
	@Override
	public boolean support(String clientId, String grantType) {
		return SecurityConstants.APP.equals(grantType);
	}

}

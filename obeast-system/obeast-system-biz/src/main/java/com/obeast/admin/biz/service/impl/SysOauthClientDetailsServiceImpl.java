package com.obeast.admin.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.obeast.admin.api.entity.SysOauthClientDetails;
import com.obeast.admin.biz.mapper.SysOauthClientDetailsMapper;
import com.obeast.admin.biz.service.SysOauthClientDetailsService;
import com.obeast.common.core.constant.CacheConstants;
import com.obeast.common.security.service.ObeastRemoteRegisteredClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * @author wxl
 * Date 2023/4/10 0:21
 * @version 1.0
 * Description: 服务实现类
 */
@Service
public class SysOauthClientDetailsServiceImpl extends ServiceImpl<SysOauthClientDetailsMapper, SysOauthClientDetails>
		implements SysOauthClientDetailsService {


	/**
	 * 通过ID删除客户端
	 * @param id id
	 */
	@Override
	@CacheEvict(value = CacheConstants.CLIENT_DETAILS_KEY, key = "#id")
	public Boolean removeClientDetailsById(String id) {
		return this.removeById(id);
	}

	@Override
	public boolean saveSysOauthClientDetails(SysOauthClientDetails sysOauthClientDetails) {
		sysOauthClientDetails.setAccessTokenValidity(ObeastRemoteRegisteredClientRepository.accessTokenValiditySeconds);
		sysOauthClientDetails.setRefreshTokenValidity(ObeastRemoteRegisteredClientRepository.refreshTokenValiditySeconds);
		return this.save(sysOauthClientDetails);
	}

	/**
	 * 根据客户端信息
	 * @param clientDetails clientDetails
	 */
	@Override
	@CacheEvict(value = CacheConstants.CLIENT_DETAILS_KEY, key = "#clientDetails.clientId")
	public Boolean updateClientDetailsById(SysOauthClientDetails clientDetails) {
		return this.updateById(clientDetails);
	}

	/**
	 * 清除客户端缓存
	 */
	@Override
	@CacheEvict(value = CacheConstants.CLIENT_DETAILS_KEY, allEntries = true)
	public void clearClientCache() {

	}

}

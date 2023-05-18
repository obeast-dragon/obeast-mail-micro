package com.obeast.admin.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.obeast.admin.api.entity.SysOauthClientDetails;

/**
 * @author wxl
 * Date 2023/4/10 0:23
 * @version 1.0
 * Description: 服务类
 */
public interface SysOauthClientDetailsService extends IService<SysOauthClientDetails> {

	/**
	 * 通过ID删除客户端
	 * @param id id
	 */
	Boolean removeClientDetailsById(String id);

	/**
	 * 修改客户端信息
	 * @param sysOauthClientDetails sysOauthClientDetails
	 */
	Boolean updateClientDetailsById(SysOauthClientDetails sysOauthClientDetails);

	/**
	 * 清除客户端缓存
	 */
	void clearClientCache();

	/**
	 * Description: 新增客户端信息
	 * @author wxl
	 * Date: 2023/5/16 19:35
	 * @param sysOauthClientDetails  sysOauthClientDetails
	 * @return boolean
	 */
	boolean saveSysOauthClientDetails(SysOauthClientDetails sysOauthClientDetails);

}

package com.obeast.admin.api.feign;


import com.obeast.admin.api.entity.SysOauthClientDetails;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.SecurityConstants;
import com.obeast.common.core.constant.SysConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * @author wxl
 * Date 2023/5/26 20:25
 * @version 1.0
 * Description: 
 */
@FeignClient(contextId = "remoteClientDetailsService", value = SysConstants.Server.SYSTEM_SERVICE)
public interface RemoteClientDetailsService {

	/**
	 * 通过clientId 查询客户端信息
	 * @param clientId 用户名
	 * @return R
	 */
	@GetMapping(value = "/client/getClientDetailsById/{clientId}", headers = SecurityConstants.HEADER_FROM_IN)
	CommonResult<SysOauthClientDetails> getClientDetailsById(@PathVariable("clientId") String clientId);

	/**
	 * 查询全部客户端
	 * @return R
	 */
	@GetMapping(value = "/client/list", headers = SecurityConstants.HEADER_FROM_IN)
	CommonResult<List<SysOauthClientDetails>> listClientDetails();

}

package com.obeast.admin.api.feign;

import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.SecurityConstants;
import com.obeast.common.core.constant.SysConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author wxl
 * Date 2023/5/13 23:52
 * @version 1.0
 * Description:
 */
@FeignClient(contextId = "remoteTokenService", value = SysConstants.Server.AUTH_SERVICE)
public interface RemoteTokenService {

	/**
	 * 分页查询token 信息
	 * @param size size
	 * @param current current
	 * @return page
	 */
	@GetMapping(value = "/token/page", headers = SecurityConstants.HEADER_FROM_IN)
	CommonResult<?> getTokenPage(@RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "current", required = false) Integer current);

	/**
	 * 删除token
	 * @param token token
	 */
	@DeleteMapping(value = "/token/{token}", headers = SecurityConstants.HEADER_FROM_IN)
	CommonResult<Boolean> removeToken(@PathVariable("token") String token);

}

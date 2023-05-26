package com.obeast.admin.api.feign;

import com.obeast.admin.api.entity.SysLog;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.SecurityConstants;
import com.obeast.common.core.constant.SysConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wxl
 * Date 2023/5/26 20:10
 * @version 1.0
 * Description:
 */
@FeignClient(contextId = "remoteLogService", value = SysConstants.Server.SYSTEM_SERVICE)
public interface RemoteLogService {

	/**
	 * 保存日志
	 * @param sysLog 日志实体
	 * @return succes、false
	 */
	@PostMapping(value = "/log", headers = SecurityConstants.HEADER_FROM_IN)
	CommonResult<Boolean> saveLog(@RequestBody SysLog sysLog);

}

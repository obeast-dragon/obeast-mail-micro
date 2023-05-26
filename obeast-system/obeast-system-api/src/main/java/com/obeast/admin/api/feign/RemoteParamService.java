package com.obeast.admin.api.feign;

import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.SecurityConstants;
import com.obeast.common.core.constant.SysConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wxl
 * Date 2023/5/26 20:10
 * @version 1.0
 * Description: 查询参数相关
 */
@FeignClient(contextId = "remoteParamService", value = SysConstants.Server.SYSTEM_SERVICE)
public interface RemoteParamService {

	/**
	 * 通过key 查询参数配置
	 * @param key key
	 * @return
	 */
	@GetMapping(value = "/param/publicValue/{key}", headers = SecurityConstants.HEADER_FROM_IN)
	CommonResult<String> getByKey(@PathVariable("key") String key);

}

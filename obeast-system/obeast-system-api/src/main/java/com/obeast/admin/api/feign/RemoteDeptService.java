package com.obeast.admin.api.feign;

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
@FeignClient(contextId = "remoteDeptService", value = SysConstants.Server.SYSTEM_SERVICE)
public interface RemoteDeptService {

	/**
	 * 查收子级id列表
	 * @return 返回子级id列表
	 */
	@GetMapping(value = "/dept/child-id/{deptId}", headers = SecurityConstants.HEADER_FROM_IN)
	CommonResult<List<Long>> listChildDeptId(@PathVariable("deptId") Long deptId);

}

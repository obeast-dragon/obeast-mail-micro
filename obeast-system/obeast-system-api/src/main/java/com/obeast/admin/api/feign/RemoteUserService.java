package com.obeast.admin.api.feign;

import com.obeast.admin.api.dto.UserInfo;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.SecurityConstants;
import com.obeast.common.core.constant.SysConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@FeignClient(contextId = "remoteUserService", value = SysConstants.Server.SYSTEM_SERVICE)
public interface RemoteUserService {

	/**
	 * 通过用户名查询用户、角色信息
	 * @param username 用户名
	 * @return R
	 */
	@GetMapping(value = "/user/info/{username}", headers = SecurityConstants.HEADER_FROM_IN)
	CommonResult<UserInfo> info(@PathVariable("username") String username);

	/**
	 * 通过手机号码查询用户、角色信息
	 * @param phone 手机号码
	 * @headers from 调用标志
	 * @return R
	 */
	@GetMapping(value = "/app/info/{phone}", headers = SecurityConstants.HEADER_FROM_IN)
	CommonResult<UserInfo> infoByMobile(@PathVariable("phone") String phone);

	/**
	 * 根据部门id，查询对应的用户 id 集合
	 * @param deptIds 部门id 集合
	 * @headers from 调用标志
	 * @return 用户 id 集合
	 */
	@GetMapping(value = "/user/ids", headers = SecurityConstants.HEADER_FROM_IN)
	CommonResult<List<Long>> listUserIdByDeptIds(@RequestParam("deptIds") Set<Long> deptIds);

}

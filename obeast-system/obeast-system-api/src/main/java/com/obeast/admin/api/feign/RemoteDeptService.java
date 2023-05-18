/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.obeast.admin.api.feign;

import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.SecurityConstants;
import com.obeast.common.core.constant.SysConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author hccake
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

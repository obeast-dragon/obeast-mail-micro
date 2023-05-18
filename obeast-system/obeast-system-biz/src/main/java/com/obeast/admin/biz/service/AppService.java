package com.obeast.admin.biz.service;

import com.obeast.admin.api.dto.AppSmsDTO;
import com.obeast.common.core.base.CommonResult;

/**
 * @author wxl
 * Date 2023/4/10 0:22
 * @version 1.0
 * Description: AppService
 */
public interface AppService {

	/**
	 * 发送手机验证码
	 * @param sms phone
	 * @return code
	 */
	CommonResult<Boolean> sendSmsCode(AppSmsDTO sms);

	/**
	 * 校验验证码
	 * @param phone 手机号
	 * @param code 验证码
	 * @return
	 */
	boolean check(String phone, String code);

}

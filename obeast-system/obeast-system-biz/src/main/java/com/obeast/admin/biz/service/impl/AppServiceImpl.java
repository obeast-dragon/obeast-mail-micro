package com.obeast.admin.biz.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.obeast.admin.api.dto.AppSmsDTO;
import com.obeast.admin.api.entity.SysUser;
import com.obeast.admin.biz.mapper.SysUserMapper;
import com.obeast.admin.biz.service.AppService;
import com.obeast.common.core.base.CommonResult;
import com.obeast.common.core.constant.CacheConstants;
import com.obeast.common.core.constant.SecurityConstants;
import com.obeast.common.core.exception.ErrorCodes;
import com.obeast.common.core.utils.MsgUtil;
import io.springboot.sms.core.SmsClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author wxl
 * Date 2023/4/10 0:20
 * @version 1.0
 * Description: 手机登录相关业务实现
 */
@Slf4j
@Service
@AllArgsConstructor
public class AppServiceImpl implements AppService {

	private final RedisTemplate redisTemplate;

	private final SysUserMapper userMapper;

	private final SmsClient smsClient;

	/**
	 * 发送手机验证码 TODO: 调用短信网关发送验证码,测试返回前端
	 * @param sms 手机号
	 * @return code
	 */
	@Override
	public CommonResult<Boolean> sendSmsCode(AppSmsDTO sms) {
		Object codeObj = redisTemplate.opsForValue().get(CacheConstants.DEFAULT_CODE_KEY + sms.getPhone());

		if (codeObj != null) {
			log.info("手机号验证码未过期:{}，{}", sms.getPhone(), codeObj);
			return CommonResult.success(Boolean.FALSE, MsgUtil.getMessage(ErrorCodes.SYS_APP_SMS_OFTEN));
		}

		// 校验手机号是否存在 sys_user 表
		if (sms.getExist()
				&& !userMapper.exists(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getPhone, sms.getPhone()))) {
			return CommonResult.success(Boolean.FALSE, MsgUtil.getMessage(ErrorCodes.SYS_APP_PHONE_UNREGISTERED, sms.getPhone()));
		}

		String code = RandomUtil.randomNumbers(Integer.parseInt(SecurityConstants.CODE_SIZE));
		log.info("手机号生成验证码成功:{},{}", sms.getPhone(), code);
		redisTemplate.opsForValue()
			.set(CacheConstants.DEFAULT_CODE_KEY + sms.getPhone(), code, SecurityConstants.CODE_TIME, TimeUnit.SECONDS);

		// 调用短信通道发送
		this.smsClient.sendCode(code, sms.getPhone());
		return CommonResult.success(Boolean.TRUE, code);
	}

	/**
	 * 校验验证码
	 * @param phone 手机号
	 * @param code 验证码
	 * @return
	 */
	@Override
	public boolean check(String phone, String code) {
		Object codeObj = redisTemplate.opsForValue().get(CacheConstants.DEFAULT_CODE_KEY + phone);

		if (Objects.isNull(codeObj)) {
			return false;
		}
		return codeObj.equals(code);
	}

}

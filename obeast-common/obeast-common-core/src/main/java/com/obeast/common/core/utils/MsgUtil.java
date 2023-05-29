package com.obeast.common.core.utils;

import lombok.experimental.UtilityClass;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * @author wxl
 * Date 2023/4/9 23:53
 * @version 1.0
 * Description: i18n 工具类
 */
@UtilityClass
public class MsgUtil {

	/**
	 * 通过code 获取中文错误信息
	 * @param code code
	 */
	public String getMessage(String code) {
		MessageSource messageSource = SpringBeanUtil.getBean("messageSource");
		return messageSource.getMessage(code, null, Locale.CHINA);
	}

	/**
	 * 通过code 和参数获取中文错误信息
	 * @param code code
	 */
	public String getMessage(String code, Object... objects) {
		MessageSource messageSource = SpringBeanUtil.getBean("messageSource");
		return messageSource.getMessage(code, objects, Locale.CHINA);
	}

	/**
	 * security 通过code 和参数获取中文错误信息
	 * @param code code
	 */
	public String getSecurityMessage(String code, Object... objects) {
		MessageSource messageSource = SpringBeanUtil.getBean("securityMessageSource");
		return messageSource.getMessage(code, objects, Locale.CHINA);
	}

}

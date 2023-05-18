package com.obeast.common.security.annotation;

import java.lang.annotation.*;

/**
 * @author wxl
 * Date 2023/4/10 0:00
 * @version 1.0
 * Description: 服务调用不鉴权注解
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inner {

	/**
	 * 是否AOP统一处理
	 * @return false, true
	 */
	boolean value() default true;

	/**
	 * 需要特殊判空的字段(预留)
	 * @return {}
	 */
	String[] field() default {};

}

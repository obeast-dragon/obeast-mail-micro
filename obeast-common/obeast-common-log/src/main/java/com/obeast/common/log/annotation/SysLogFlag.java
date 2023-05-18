package com.obeast.common.log.annotation;

import java.lang.annotation.*;

/**
 * @author wxl
 * Date 2023/4/9 23:43
 * @version 1.0
 * Description: 操作日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogFlag {

	/**
	 * 描述
	 * @return {String}
	 */
	String value() default "";

	/**
	 * spel 表达式
	 * @return 日志描述
	 */
	String expression() default "";

}

package com.obeast.common.xss.core;

import java.lang.annotation.*;

/**
 * @author wxl
 * Date 2023/4/10 0:08
 * @version 1.0
 * Description: 忽略 xss
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XssCleanIgnore {

	/**
	 * @return 需要跳过的字段列表
	 */
	String[] value() default {};

}

package com.obeast.common.xss.core;

import lombok.Getter;

/**
 * @author wxl
 * Date 2023/4/10 0:09
 * @version 1.0
 * Description:  xss 表单异常
 */
@Getter
public class FromXssException extends IllegalStateException implements XssException {

	private final String input;

	public FromXssException(String input, String message) {
		super(message);
		this.input = input;
	}

}

package com.obeast.common.xss.core;

import lombok.Getter;

import java.io.IOException;

/**
 * @author wxl
 * Date 2023/4/10 0:09
 * @version 1.0
 * Description: xss jackson 异常
 */
@Getter
public class JacksonXssException extends IOException implements XssException {

	private final String input;

	public JacksonXssException(String input, String message) {
		super(message);
		this.input = input;
	}

}

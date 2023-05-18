package com.obeast.common.core.exception;

/**
 * @author wxl
 * Date 2023/4/9 23:53
 * @version 1.0
 * Description: ValidateCodeException
 */
public class ValidateCodeException extends RuntimeException {

	private static final long serialVersionUID = -7285211528095468156L;

	public ValidateCodeException() {
	}

	public ValidateCodeException(String msg) {
		super(msg);
	}

}

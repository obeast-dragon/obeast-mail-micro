package com.obeast.common.xss.core;

/**
 * @author wxl
 * Date 2023/4/10 0:09
 * @version 1.0
 * Description: xss 数据处理类型
 */
public enum XssType {

	/**
	 * 表单
	 */
	FORM() {
		@Override
		public RuntimeException getXssException(String input, String message) {
			return new FromXssException(input, message);
		}
	},

	/**
	 * body json
	 */
	JACKSON() {
		@Override
		public RuntimeException getXssException(String input, String message) {
			return new RuntimeException(message);
		}
	};

	/**
	 * 获取 xss 异常
	 * @param input input
	 * @param message message
	 * @return XssException
	 */
	public abstract RuntimeException getXssException(String input, String message);

}

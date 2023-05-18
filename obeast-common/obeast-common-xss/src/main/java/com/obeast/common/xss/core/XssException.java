package com.obeast.common.xss.core;

/**
 * @author wxl
 * Date 2023/4/10 0:08
 * @version 1.0
 * Description: xss 异常，校验模式抛出
 */
public interface XssException {

	/**
	 * 输入的数据
	 * @return 数据
	 */
	String getInput();

	/**
	 * 获取异常的消息
	 * @return 消息
	 */
	String getMessage();

}

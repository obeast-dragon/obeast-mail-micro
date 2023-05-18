package com.obeast.common.xss.core;

import com.obeast.common.xss.utils.XssUtil;
import org.jsoup.Jsoup;

/**
 * @author wxl
 * Date 2023/4/10 0:07
 * @version 1.0
 * Description: xss 清理器
 */
public interface XssCleaner {

	/**
	 * 清理 html
	 * @param html html
	 * @return 清理后的数据
	 */
	default String clean(String html) {
		return clean(html, XssType.FORM);
	}

	/**
	 * 清理 html
	 * @param html html
	 * @param type XssType
	 * @return 清理后的数据
	 */
	String clean(String html, XssType type);

	/**
	 * 判断输入是否安全
	 * @param html html
	 * @return 是否安全
	 */
	default boolean isValid(String html) {
		return Jsoup.isValid(html, XssUtil.WHITE_LIST);
	}

}

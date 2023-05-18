package com.obeast.common.xss.core;

import com.obeast.common.core.utils.SpringBeanUtil;
import com.obeast.common.xss.config.ObeastXssProperties;
import com.obeast.common.xss.utils.XssUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author wxl
 * Date 2023/4/10 0:08
 * @version 1.0
 * Description: jackson xss 处理
 */
@Slf4j
public class XssCleanDeserializer extends XssCleanDeserializerBase {

	@Override
	public String clean(String name, String text) throws IOException {
		// 读取 xss 配置
		ObeastXssProperties properties = SpringBeanUtil.getBean(ObeastXssProperties.class);
		// 读取 XssCleaner bean
		XssCleaner xssCleaner = SpringBeanUtil.getBean(XssCleaner.class);
		if (xssCleaner != null) {
			String value = xssCleaner.clean(XssUtil.trim(text, properties.isTrimText()));
			log.debug("Json property value:{} cleaned up by mica-xss, current value is:{}.", text, value);
			return value;
		}
		else {
			return XssUtil.trim(text, properties.isTrimText());
		}
	}

}

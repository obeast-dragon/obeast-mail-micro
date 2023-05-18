package com.obeast.common.feign;

import com.obeast.common.feign.retry.FeignRetryAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author wxl
 * Date 2023/4/4 1:32
 * @version 1.0
 * Description: 重试配置
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(RetryTemplate.class)
public class ObeastFeignRetryAutoConfiguration {

	@Bean
	public FeignRetryAspect feignRetryAspect() {
		return new FeignRetryAspect();
	}

}

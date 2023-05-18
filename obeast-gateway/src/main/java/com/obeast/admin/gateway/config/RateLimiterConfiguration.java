package com.obeast.admin.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author wxl
 * Date 2023/4/10 0:11
 * @version 1.0
 * Description: 路由限流配置
 */
@Configuration(proxyBeanMethods = false)
public class RateLimiterConfiguration {

	/**
	 * Remote addr key resolver key resolver.
	 *
	 * @link {https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/#the-requestratelimiter-gatewayfilter-factory}
	 */
	@Bean
	public KeyResolver remoteAddrKeyResolver() {
		return exchange -> Mono
			.just(Objects.requireNonNull(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()))
				.getAddress()
				.getHostAddress());
	}

}

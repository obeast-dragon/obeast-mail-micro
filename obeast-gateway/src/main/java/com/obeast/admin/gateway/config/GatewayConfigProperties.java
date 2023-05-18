package com.obeast.admin.gateway.config;

import com.obeast.admin.gateway.filter.PasswordDecoderFilter;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;

/**
 * @author wxl
 * Date 2023/4/10 0:10
 * @version 1.0
 * Description: 网关配置文件
 */
@Data
@RefreshScope
@ConfigurationProperties("gateway")
public class GatewayConfigProperties {

	/**
	 * 网关解密登录前端密码 秘钥 {@link PasswordDecoderFilter}
	 */
	private String encodeKey;

	/**
	 * 网关不需要校验验证码的客户端 {@link PasswordDecoderFilter}
	 */
	private List<String> ignoreClients;

}

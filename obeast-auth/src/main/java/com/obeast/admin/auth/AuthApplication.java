package com.obeast.admin.auth;

import com.obeast.common.feign.annotation.EnableObeastFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wxl
 * Date 2023/4/4 0:28
 * @version 1.0
 * Description: 授权服务
 */
@EnableObeastFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}

package com.obeast.admin.biz;

import com.obeast.common.feign.annotation.EnableObeastFeignClients;
import com.obeast.common.security.annotation.EnableObeastResourceServer;
import com.obeast.common.swagger.annotation.EnableObeastSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wxl
 * Date 2023/4/29 23:11
 * @version 1.0
 * Description: 用户统一管理系统
 */
@EnableObeastSwagger
@EnableObeastResourceServer
@EnableObeastFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}

package com.obeast.member.biz;

import com.obeast.common.feign.annotation.EnableObeastFeignClients;
import com.obeast.common.security.annotation.EnableObeastResourceServer;
import com.obeast.common.swagger.annotation.EnableObeastSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wxl
 * Date 2023/5/21 20:54
 * @version 1.0
 * Description: 会员服务
 */
@EnableObeastSwagger
@EnableObeastResourceServer
@EnableObeastFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}

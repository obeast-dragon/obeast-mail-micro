package com.obeast.order.biz;

import com.obeast.common.feign.annotation.EnableObeastFeignClients;
import com.obeast.common.security.annotation.EnableObeastResourceServer;
import com.obeast.common.swagger.annotation.EnableObeastSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wxl
 * Date 2023/5/19 1:41
 * @version 1.0
 * Description: 订单服务
 */
@EnableObeastSwagger
@EnableObeastResourceServer
@EnableObeastFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}

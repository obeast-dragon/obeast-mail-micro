package com.obeast.common.oss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author wxl
 * Date 2023/4/9 9:49
 * @version 1.0
 * Description: oss 配置类
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "oss")
public class OssProperties {

    /**
     * 对象存储服务的URL
     */
    private String endpoint;

    /**
     * Access key
     */
    private String accessKey;

    /**
     * Secret key
     */
    private String secretKey;

    /**
     * 区域
     */
    private String region;

    /**
     * 桶名
     * */
    private String bucketName;

    /**
     * true path-style nginx 反向代理和S3默认支持 pathStyle模式 {<a href="http://endpoint/bucketname">...</a>}
     * false supports virtual-hosted-style 阿里云等需要配置为 virtual-hosted-style 模式{<a href="http://bucketname.endpoint">...</a>}
     * 只是url的显示不一样
     */
    private Boolean pathStyleAccess = true;

    /**
     * 最大线程数，默认： 100
     */
    private Integer maxConnections = 100;
}

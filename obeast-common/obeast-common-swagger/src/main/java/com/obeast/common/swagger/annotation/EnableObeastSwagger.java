package com.obeast.common.swagger.annotation;

import com.obeast.common.swagger.config.SwaggerAutoConfiguration;
import com.obeast.common.swagger.support.SwaggerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wxl
 * Date 2023/4/10 0:06
 * @version 1.0
 * Description: swagger configuration
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableConfigurationProperties(SwaggerProperties.class)
@Import({ SwaggerAutoConfiguration.class })
public @interface EnableObeastSwagger {

}

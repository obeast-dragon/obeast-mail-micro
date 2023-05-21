package com.obeast.common.security.annotation;

import com.obeast.common.security.component.ObeastResourceServerAutoConfiguration;
import com.obeast.common.security.component.ObeastResourceServerConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.lang.annotation.*;

/**
 * @author wxl
 * Date 2023/4/10 0:00
 * @version 1.0
 * Description: 资源服务注解
 */
@Documented
@Inherited
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({ ObeastResourceServerAutoConfiguration.class, ObeastResourceServerConfiguration.class })
public @interface EnableObeastResourceServer {

}

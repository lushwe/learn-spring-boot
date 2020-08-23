package com.lushwe.condition.one;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-08-10 13:50
 * @since 0.1
 */
@Configuration
@ConditionalOnClass(OneBean.class)
@ConditionalOnProperty(prefix = "spring.bean.one", name = "enable", havingValue = "true")
@AutoConfigureOrder
public class OneBeanConfig {

    @Bean
    public OneBean oneBean() {
        return new OneBean();
    }
}

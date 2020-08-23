package com.lushwe.condition.two;

import com.lushwe.condition.one.OneBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
@ConditionalOnProperty(prefix = "spring.bean", name = "one", havingValue = "true")
public class TwoBeanConfig {

    @Bean
    @ConditionalOnMissingBean
    public OneBean oneBean1() {
        return new OneBean();
    }

//    @Bean
//    @ConditionalOnMissingBean
//    public OneBean oneBean1() {
//        return new OneBean();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public OneBean oneBean2() {
//        return new OneBean();
//    }
}

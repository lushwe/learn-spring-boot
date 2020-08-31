package com.lushwe.spring.boot.i18n.config;

import com.lushwe.spring.boot.i18n.filter.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-08-24 15:38
 * @since 0.1
 */
@Configuration
public class AuthConfig {

    @Bean
    public FilterRegistrationBean<AuthFilter> userAuthFilter(MessageSource messageSource) {
        AuthFilter authFilter = new AuthFilter(messageSource);

        FilterRegistrationBean<AuthFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(authFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;
    }
}

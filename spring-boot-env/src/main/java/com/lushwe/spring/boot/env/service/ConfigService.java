package com.lushwe.spring.boot.env.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 说明：配置服务
 *
 * @author Jack Liu
 * @date 2020-07-19 10:05
 * @since 0.1
 */
@Component
public class ConfigService {

    @Value("${callback.url}")
    private String callbackUrl;

    @Resource
    private Environment environment;

    public String getCallbackUrl() {
        return callbackUrl;
    }


    public String getProperty(String key) {

       return environment.getProperty(key);

    }
}

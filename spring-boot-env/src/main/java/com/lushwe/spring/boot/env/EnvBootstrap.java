package com.lushwe.spring.boot.env;

import com.lushwe.spring.boot.env.service.ConfigService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 说明：应用启动类
 *
 * @author Jack Liu
 * @date 2020-05-07 19:18
 * @since 1.0
 */
@SpringBootApplication
public class EnvBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(EnvBootstrap.class, args);

        ConfigService configService = context.getBean(ConfigService.class);

        System.out.println("回调URL: " + configService.getCallbackUrl());

        System.out.println("回调url: " + configService.getProperty("callback.url"));
    }
}

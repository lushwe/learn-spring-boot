package com.lushwe.spring.boot.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 说明：启动类
 *
 * @author Jack Liu
 * @date 2019-11-01 15:28
 * @since 0.1
 */
@SpringBootApplication
public class AopBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(AopBootstrap.class, args);
        System.out.println();
    }
}

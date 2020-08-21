package com.lushwe.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 说明：启动类
 *
 * @author Jack Liu
 * @date 2019-08-20 16:21
 * @since 0.1
 */
@EnableAsync
@SpringBootApplication
public class EventBootstrap {

    public static void main(String[] args) {

        SpringApplication.run(EventBootstrap.class, args);

    }
}

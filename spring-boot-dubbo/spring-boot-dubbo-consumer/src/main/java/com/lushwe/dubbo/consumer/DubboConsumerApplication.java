package com.lushwe.dubbo.consumer;

import com.lushwe.dubbo.consumer.service.TestService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2021-09-10 23:00
 * @since 0.1
 */
@EnableDubbo
@SpringBootApplication
public class DubboConsumerApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DubboConsumerApplication.class, args);
        TestService testService = context.getBean(TestService.class);
        testService.test();
    }
}

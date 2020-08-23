package com.lushwe.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 说明：应用启动类
 *
 * @author Jack Liu
 * @date 2019-05-07 19:18
 * @since 1.0
 */
@SpringBootApplication
public class KafkaConsumerBootstrap {

    public static void main(String[] args) {

        SpringApplication.run(KafkaConsumerBootstrap.class, args);

    }
}

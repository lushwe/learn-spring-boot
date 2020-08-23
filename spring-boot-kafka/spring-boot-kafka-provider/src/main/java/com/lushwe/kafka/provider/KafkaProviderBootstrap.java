package com.lushwe.kafka.provider;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 说明：应用启动类
 *
 * @author Jack Liu
 * @date 2019-05-07 19:18
 * @since 1.0
 */
@SpringBootApplication
public class KafkaProviderBootstrap {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public static void main(String[] args) {

        SpringApplication.run(KafkaProviderBootstrap.class, args);

    }

    @Component
    class KafkaRunner implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) throws Exception {

            testThreadSend();
        }
    }

    private void testThreadSend() throws InterruptedException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1L);
        jsonObject.put("name", "张三");
        jsonObject.put("age", 24);

        Thread thread1 = new Thread(() -> {
            System.out.println("发送");
            kafkaTemplate.send("test_2020", jsonObject.toString());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("发送");
            kafkaTemplate.send("test_2020", jsonObject.toString());
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("发送");
            kafkaTemplate.send("test_2020", jsonObject.toString());
        });

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        thread3.start();
        thread3.join();
    }
}

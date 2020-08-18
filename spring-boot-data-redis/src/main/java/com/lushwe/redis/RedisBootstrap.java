package com.lushwe.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-08-14 14:29
 * @since 0.1
 */
@SpringBootApplication
public class RedisBootstrap {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RedisBootstrap.class, args);
    }

    @Component
    class RedisRunner implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) throws Exception {
            String key = "learn:redis:lushwe";
            stringRedisTemplate.opsForValue().set(key, "Jack Liu");
            String value = stringRedisTemplate.opsForValue().get(key);
            System.out.println("value=" + value);
        }
    }

    private static void testBit() {

        // bitmap
//        Boolean setBit = stringRedisTemplate.opsForValue().setBit("sys:001", 100, true);
//        System.out.println(setBit);
//        Boolean bitResult = stringRedisTemplate.opsForValue().getBit("sys:001", 100);
//        System.out.println(bitResult);

//        String value = stringRedisTemplate.opsForValue().get("sys:001");
//        System.out.println(value);

//        Long size = stringRedisTemplate.opsForValue().size("sys:001");
//        System.out.println(size);
    }
}

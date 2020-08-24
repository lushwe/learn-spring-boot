package com.lushwe.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 说明：启动类
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
            testGet();
            testIncrement();
            testBit();
        }
    }

    private void testGet() {

        String key = "learn:redis:lushwe";

        stringRedisTemplate.opsForValue().set(key, "Jack Liu");
        String value = stringRedisTemplate.opsForValue().get(key);
        System.out.println("value=" + value);

        // 删除
        stringRedisTemplate.delete(key);
    }

    private void testIncrement() {

        String key = "learn:redis:lushwe:in";

        Long increment = null;
        increment = stringRedisTemplate.opsForValue().increment(key);
        System.out.println("increment=" + increment);
        increment = stringRedisTemplate.opsForValue().increment(key);
        System.out.println("increment=" + increment);

        // 删除
        stringRedisTemplate.delete(key);
    }

    private void testBit() {

        String key = "sys:001";

        // bitmap
        Boolean setBit = stringRedisTemplate.opsForValue().setBit(key, 100, true);
        System.out.println(setBit);
        Boolean bitResult = stringRedisTemplate.opsForValue().getBit(key, 100);
        System.out.println(bitResult);

        String value = stringRedisTemplate.opsForValue().get(key);
        System.out.println(value);

        Long size = stringRedisTemplate.opsForValue().size(key);
        System.out.println(size);

        // 删除
        stringRedisTemplate.delete(key);
    }
}

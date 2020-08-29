package com.lushwe.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

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
//            testGet();
//            testIncrement();
//            testBit();
            testHash();
//            testZSet();
        }
    }

    /**
     * 测试 String set/get
     */
    private void testGet() {

        String key = "learn:redis:lushwe";

        stringRedisTemplate.opsForValue().set(key, "Jack Liu");
        String value = stringRedisTemplate.opsForValue().get(key);
        System.out.println("value=" + value);

        // 删除
        stringRedisTemplate.delete(key);
    }

    /**
     * 测试 String increment
     */
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

    /**
     * 测试 String bit
     */
    private void testBit() {

        String key = "system:string:bit:001";

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

    /**
     * 测试 Hash
     */
    private void testHash() {
        String key = "system:hash:user";
//        stringRedisTemplate.opsForHash().put(key, "id", "1");
//        stringRedisTemplate.opsForHash().put(key, "name", "zhangsan");
//        stringRedisTemplate.opsForHash().put(key, "age", "24");

        System.out.println("user.id=" + stringRedisTemplate.opsForHash().get(key, "id"));
        System.out.println("user.name=" + stringRedisTemplate.opsForHash().get(key, "name"));
        System.out.println("user.age=" + stringRedisTemplate.opsForHash().get(key, "age"));

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
        System.out.println("entries=" + JSON.toJSONString(entries, true));
    }

    /**
     * 测试 ZSet
     */
    private void testZSet() {
        String key = "system:zset";
//        stringRedisTemplate.opsForZSet().add(key, "z1", 1);
//        stringRedisTemplate.opsForZSet().add(key, "z2", 2);
//        stringRedisTemplate.opsForZSet().add(key, "z3", 3);

        System.out.println("z1.score=" + stringRedisTemplate.opsForZSet().score(key, "z1"));

        System.out.println("z1.rank=" + stringRedisTemplate.opsForZSet().rank(key, "z1"));
        System.out.println("z2.rank=" + stringRedisTemplate.opsForZSet().rank(key, "z2"));
        System.out.println("z3.rank=" + stringRedisTemplate.opsForZSet().rank(key, "z3"));
        System.out.println("z3.reverseRank=" + stringRedisTemplate.opsForZSet().reverseRank(key, "z1"));
        System.out.println("z3.reverseRank=" + stringRedisTemplate.opsForZSet().reverseRank(key, "z2"));
        System.out.println("z3.reverseRank=" + stringRedisTemplate.opsForZSet().reverseRank(key, "z3"));
    }
}

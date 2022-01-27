package com.lushwe.learn.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * 缓存配置
 *
 * @author liusw
 * @version V1.0
 * @since 1/14/22 5:00 PM
 */
@EnableCaching
@Configuration
public class CacheConfig {

    /**
     * caffeine本地缓存管理器
     *
     * @return
     */
    @Primary
    @Bean
    public CacheManager caffeineCacheManager() {

        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();

        Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .initialCapacity(100)
                .maximumSize(10000);

        caffeineCacheManager.setCaffeine(caffeine);

        return caffeineCacheManager;
    }

    /**
     * redis缓存管理器
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(10))
                .prefixCacheNameWith("spring-boot-cache:")
                .disableCachingNullValues()
                .serializeKeysWith(keySerializationPair())
                .serializeValuesWith(valueSerializationPair());

        RedisCacheConfiguration redisCacheConfiguration1 = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(10))
                .prefixCacheNameWith("spring-boot-cache-1:")
                .disableCachingNullValues()
                .serializeKeysWith(keySerializationPair())
                .serializeValuesWith(valueSerializationPair());

        RedisCacheConfiguration redisCacheConfiguration2 = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(10))
                .prefixCacheNameWith("spring-boot-cache-2:")
                .disableCachingNullValues()
                .serializeKeysWith(keySerializationPair())
                .serializeValuesWith(valueSerializationPair());

        RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .withCacheConfiguration("redis1", redisCacheConfiguration1)
                .withCacheConfiguration("redis2", redisCacheConfiguration2)
                .build();

        return redisCacheManager;
    }

    private RedisSerializationContext.SerializationPair<String> keySerializationPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
    }

    private RedisSerializationContext.SerializationPair<?> valueSerializationPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericFastJsonRedisSerializer());
    }
}

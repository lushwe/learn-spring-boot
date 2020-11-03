package com.lushwe.spring.boot.aop.config;

import com.lushwe.spring.boot.aop.aspect.CacheDataAspect;
import com.lushwe.spring.boot.aop.aspect.cache.LocalCacheDataAspect;
import com.lushwe.spring.boot.aop.aspect.cache.RedisCacheDataAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 说明：缓存数据切面配置
 *
 * @author Jack Liu
 * @date 2019-11-01 16:49
 * @since 0.1
 */
@Configuration
public class CacheDataAspectConfig {

    @Bean
    @ConditionalOnProperty(name = "cache.data.value", havingValue = "redis")
    public CacheDataAspect redisCacheDataAspect(StringRedisTemplate stringRedisTemplate) {
        return new RedisCacheDataAspect(stringRedisTemplate);
    }

    @Bean
    @ConditionalOnProperty(name = "cache.data.value", havingValue = "local")
    public CacheDataAspect localCacheDataAspect() {
        return new LocalCacheDataAspect();
    }
}

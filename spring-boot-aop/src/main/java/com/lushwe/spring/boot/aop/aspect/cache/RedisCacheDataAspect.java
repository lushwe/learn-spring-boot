package com.lushwe.spring.boot.aop.aspect.cache;

import com.lushwe.spring.boot.aop.aspect.CacheDataAspect;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 说明：Redis缓存数据切面
 *
 * @author Jack Liu
 * @date 2019-11-01 16:06
 * @since 0.1
 */
public class RedisCacheDataAspect extends CacheDataAspect {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisCacheDataAspect(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    protected void saveDataToCache(String cacheKey, String value) {
        stringRedisTemplate.opsForValue().set(cacheKey, value);
    }

    @Override
    protected String findDataFromCache(String cacheKey) {
        return stringRedisTemplate.opsForValue().get(cacheKey);
    }
}

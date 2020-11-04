package com.lushwe.spring.boot.aop.aspect.cache;

import com.lushwe.spring.boot.aop.aspect.CacheDataAspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 说明：本地缓存数据切面
 *
 * @author Jack Liu
 * @date 2019-11-01 16:51
 * @since 0.1
 */
public class LocalCacheDataAspect extends CacheDataAspect {

    private static final Map<String, String> map = new ConcurrentHashMap<>();

    @Override
    protected String findDataFromCache(String cacheKey) {
        return map.get(cacheKey);
    }

    @Override
    protected void saveDataToCache(String cacheKey, String value) {
        map.put(cacheKey, value);
    }
}

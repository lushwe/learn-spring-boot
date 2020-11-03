package com.lushwe.spring.boot.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.lushwe.spring.boot.aop.annotation.CacheData;
import com.lushwe.spring.boot.aop.util.AspectUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 说明：缓存数据环绕切面抽象类
 *
 * @author Jack Liu
 * @date 2019-11-01 15:34
 * @since 0.1
 */
@Slf4j
@Order(value = Ordered.LOWEST_PRECEDENCE - 2)
@Aspect
public abstract class CacheDataAspect {

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @param cacheData
     * @return
     * @throws Throwable
     */
    @Around("@annotation(cacheData)")
    public Object around(ProceedingJoinPoint joinPoint, CacheData cacheData) throws Throwable {
        // 从缓存获取数据
        Object cacheResult = findDataFromCache(joinPoint, cacheData);
        if (cacheResult != null) {
            log.info("缓存命中，直接返回");
            return cacheResult;
        }
        // 执行查询（一般是查询数据库）
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("缓存数据切面异常", e);
            throw e;
        }
        // 保存数据到缓存
        saveDataToCache(joinPoint, cacheData, result);
        // 返回
        return result;
    }

    /**
     * 保存数据到缓存
     *
     * @param joinPoint
     * @param cacheData
     * @param result
     */
    private void saveDataToCache(ProceedingJoinPoint joinPoint, CacheData cacheData, Object result) {

        String cacheKey = buildCacheKey(joinPoint, cacheData);

        saveDataToCache(cacheKey, JSON.toJSONString(result));

        log.info("数据保存到缓存, cacheKey={}, result={}", cacheKey, JSON.toJSONString(result));
    }

    /**
     * 从缓存中查询数据
     *
     * @param joinPoint
     * @param cacheData
     * @return
     */
    private Object findDataFromCache(ProceedingJoinPoint joinPoint, CacheData cacheData) {

        String cacheKey = buildCacheKey(joinPoint, cacheData);

        String value = findDataFromCache(cacheKey);

        log.info("从缓存中获取数据, cacheKey={}, value={}", cacheKey, value);

        if (StringUtils.isEmpty(value)) {
            return null;
        }

        MethodSignature methodSignature = ((MethodSignature) joinPoint.getSignature());

        return JSON.parseObject(value, methodSignature.getReturnType());
    }

    /**
     * 从缓存获取数据
     *
     * @param cacheKey
     * @return
     */
    protected abstract String findDataFromCache(String cacheKey);

    /**
     * 保存数据到缓存
     *
     * @param cacheKey
     * @param value
     */
    protected abstract void saveDataToCache(String cacheKey, String value);


    /**
     * 构建缓存Key
     *
     * @param joinPoint
     * @param cacheData
     * @return
     */
    private String buildCacheKey(ProceedingJoinPoint joinPoint, CacheData cacheData) {

        MethodSignature methodSignature = ((MethodSignature) joinPoint.getSignature());

        StringBuilder cacheKey = new StringBuilder();

        if (!StringUtils.isEmpty(cacheData.cacheKey())) {
            cacheKey.append(cacheData.cacheKey());
        } else {
            cacheKey.append(methodSignature.getMethod().toString().hashCode());
            cacheKey.append(".");
            cacheKey.append(methodSignature.getMethod().getName());
        }

        cacheKey.append(":");

        if (!StringUtils.isEmpty(cacheData.paramKey())) {
            Map<String, Object> paramMap = AspectUtils.getInParam(joinPoint);
            cacheKey.append(paramMap.get(cacheData.paramKey()));
        } else {
            if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
                cacheKey.append(joinPoint.getArgs()[0]);
            }
        }
        return cacheKey.toString();
    }

}

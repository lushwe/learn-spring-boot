package com.lushwe.spring.boot.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明：缓存数据注解
 *
 * @author Jack Liu
 * @date 2019-11-01 15:23
 * @since 0.1
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheData {

    /**
     * 缓存Key，默认取方法完整签名
     *
     * @return
     */
    String cacheKey() default "";

    /**
     * 参数Key，默认取方法第一个参数
     *
     * @return
     */
    String paramKey() default "";
}

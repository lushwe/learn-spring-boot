package com.lushwe.spring.boot.aop.annotation;

import com.lushwe.spring.boot.aop.enums.OperationLogType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明：操作日志注解
 *
 * @author Jack Liu
 * @date 2018/12/12 下午3:01
 * @since 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    /**
     * 操作日志类型
     *
     * @return
     */
    OperationLogType type();

}

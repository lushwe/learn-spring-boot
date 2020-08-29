package com.lushwe.spring.boot.async.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * 说明：异步异常处理器
 *
 * @author Jack Liu
 * @date 2019-08-20 17:08
 * @since 0.1
 */
@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {

        log.error("异步执行[{}]异常", method.getName(), ex);

    }
}

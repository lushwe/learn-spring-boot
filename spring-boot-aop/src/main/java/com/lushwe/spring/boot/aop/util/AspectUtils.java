package com.lushwe.spring.boot.aop.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明：切面工具类
 *
 * @author Jack Liu
 * @date 2019-11-01 20:53
 * @since 0.1
 */
public class AspectUtils {

    /**
     * 获取入参信息（不支持嵌套）
     *
     * @param joinPoint
     * @return
     */
    public static Map<String, Object> getInParam(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return Collections.emptyMap();
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        if (parameterNames == null || parameterNames.length == 0) {
            return Collections.emptyMap();
        }
        Map<String, Object> map = new HashMap<>(args.length);
        for (int i = 0; i < args.length; i++) {
            map.put(parameterNames[i], args[i]);
        }
        return map;
    }
}

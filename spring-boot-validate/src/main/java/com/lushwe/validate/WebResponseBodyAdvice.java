package com.lushwe.validate;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 说明：Web响应Body统一封装
 *
 * @author Jack Liu
 * @date 2021-06-24 00:18
 * @since 0.1
 */
@ControllerAdvice
public class WebResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class clazz) {
        System.out.println(methodParameter);
        System.out.println(clazz);
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class clazz, ServerHttpRequest request, ServerHttpResponse response) {
        if (o instanceof WebResult) {
            return o;
        }
        return WebResult.success(o);
    }
}

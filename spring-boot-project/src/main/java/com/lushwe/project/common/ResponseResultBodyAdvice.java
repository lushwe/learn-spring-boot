package com.lushwe.project.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

/**
 * 说明：统一封装返回结果格式
 *
 * @author Jack Liu
 * @date 2020-09-11 17:35
 * @since 0.1
 */
@RestControllerAdvice
public class ResponseResultBodyAdvice implements ResponseBodyAdvice<Object> {

    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseResultBody.class;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // 判断类或者方法是否使用了 @ResponseResultBody
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE) || returnType.hasMethodAnnotation(ANNOTATION_TYPE);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 防止重复包裹的问题出现
        if (body instanceof Result) {
            return body;
        }
        // String类型不能直接包装，所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            return doStringResult(body);
        }
        return Result.success(body);
    }

    /**
     * 处理String
     *
     * @param body
     * @return
     */
    private Object doStringResult(Object body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 将数据包装在Result里后，再转换为json字符串响应给前端
            return objectMapper.writeValueAsString(Result.success(body));
        } catch (JsonProcessingException e) {
            throw new BizException(500, "返回String类型错误");
        }
    }
}

package com.lushwe.validate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;
import java.util.Set;

/**
 * 说明：Web全局异常处理器
 *
 * @author Jack Liu
 * @date 2021-06-23 23:29
 * @since 0.1
 */
@Slf4j
@ControllerAdvice
public class WebGlobalExceptionHandler {

    private ConstraintViolation constraintViolation = new WebConstraintViolation();

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public WebResult handleException(HttpMessageNotReadableException e) {
        return WebResult.fail(1, "请求体为空");
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public WebResult handleException(MethodArgumentNotValidException e) {
        return WebResult.fail(2, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public WebResult handleException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        String message = constraintViolations.stream().findFirst().orElse(constraintViolation).getMessage();
        return WebResult.fail(2, message);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public WebResult handleException(Exception e) {
        log.error("系统异常", e);
        return WebResult.fail(3, e.getMessage());
    }

    static class WebConstraintViolation implements ConstraintViolation {

        @Override
        public String getMessage() {
            return "参数不合法";
        }

        @Override
        public String getMessageTemplate() {
            return null;
        }

        @Override
        public Object getRootBean() {
            return null;
        }

        @Override
        public Class getRootBeanClass() {
            return null;
        }

        @Override
        public Object getLeafBean() {
            return null;
        }

        @Override
        public Object[] getExecutableParameters() {
            return new Object[0];
        }

        @Override
        public Object getExecutableReturnValue() {
            return null;
        }

        @Override
        public Path getPropertyPath() {
            return null;
        }

        @Override
        public Object getInvalidValue() {
            return null;
        }

        @Override
        public ConstraintDescriptor<?> getConstraintDescriptor() {
            return null;
        }

        @Override
        public Object unwrap(Class type) {
            return null;
        }
    }
}

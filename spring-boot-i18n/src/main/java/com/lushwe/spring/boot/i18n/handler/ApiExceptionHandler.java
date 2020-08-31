package com.lushwe.spring.boot.i18n.handler;

import com.lushwe.spring.boot.i18n.entity.ApiResultEntity;
import com.lushwe.spring.boot.i18n.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.util.Locale;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-08-24 14:41
 * @since 0.1
 */
@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    @Resource
    private MessageSource messageSource;


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgumentExceptionHandler(IllegalArgumentException e, WebRequest request) {

        log.error("illegalArgumentExceptionHandler", e);

        ApiResultEntity<Boolean> entity = new ApiResultEntity<>();
        entity.setCode(0);
        entity.setMsg(getMessage(entity.getCode() + ""));

        return handleExceptionInternal(e, entity, new HttpHeaders(), HttpStatus.OK, request);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> constraintViolationExceptionHandler(ConstraintViolationException e, WebRequest request) {

        log.error("constraintViolationExceptionHandler", e);

        ApiResultEntity<Boolean> entity = new ApiResultEntity<>();
        entity.setCode(0);
        entity.setMsg(getMessage(entity.getCode() + ""));

        return handleExceptionInternal(e, entity, new HttpHeaders(), HttpStatus.OK, request);
    }

    @ExceptionHandler(BizException.class)
    public ResponseEntity<Object> bizExceptionHandler(BizException e, WebRequest request) {

        log.error("bizExceptionHandler", e);

        ApiResultEntity<Boolean> entity = new ApiResultEntity<>();
        entity.setCode(e.getCode());
        entity.setMsg(getMessage(entity.getCode() + ""));

        return handleExceptionInternal(e, entity, new HttpHeaders(), HttpStatus.OK, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionHandler(Exception e, WebRequest request) {

        log.error("exceptionHandler", e);

        ApiResultEntity<Boolean> entity = new ApiResultEntity<>();
        entity.setCode(0);
        entity.setMsg(getMessage(entity.getCode() + ""));

        return handleExceptionInternal(e, entity, new HttpHeaders(), HttpStatus.OK, request);
    }


    private String getMessage(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, "success", locale);
    }
}

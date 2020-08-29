package com.lushwe.learn.exception;

import com.lushwe.learn.entity.ApiRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 异常统一处理，方式二（推荐使用）
 *
 * @author Jack Liu
 * @date 2018/9/1 19:47
 */
@Slf4j
@ControllerAdvice
public class ApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<Object> doHandleApiException(Exception e, WebRequest request) {

        log.error("接口出现异常", e);

        ApiRes entity = ExceptionUtils.buildApiResultEntity(e);

        return handleExceptionInternal(e, entity, new HttpHeaders(), HttpStatus.OK, request);
    }
}

package com.lushwe.learn.exception;

import com.lushwe.learn.entity.ApiRes;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintViolationException;

/**
 * 说明：异常工具类
 *
 * @author Jack Liu
 * @date 2019/2/28 上午9:40
 * @since 1.0
 */
public class ExceptionUtils {

    /**
     * 根据异常构造返回结果
     *
     * @param e 异常
     * @return 返回结果对象
     */
    public static ApiRes buildApiResultEntity(Exception e) {

        ApiRes apiRes = new ApiRes();

        if (e instanceof IllegalArgumentException) {
            apiRes.setCode(HttpStatus.CONFLICT.value());
            apiRes.setMsg(e.getMessage());
        } else if (e instanceof ConstraintViolationException) {
            apiRes.setCode(HttpStatus.CONFLICT.value());
            apiRes.setMsg(e.getMessage());
        } else {
            apiRes.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiRes.setMsg(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }

        return apiRes;
    }
}

package com.lushwe.project.common;

/**
 * 说明：自定义业务异常
 *
 * @author Jack Liu
 * @date 2020-09-11 17:39
 * @since 0.1
 */
public class BizException extends RuntimeException {

    private int code;

    private String message;

    public BizException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}

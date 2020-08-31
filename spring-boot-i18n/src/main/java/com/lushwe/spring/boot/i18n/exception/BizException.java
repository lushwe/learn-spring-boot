package com.lushwe.spring.boot.i18n.exception;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-08-24 15:17
 * @since 0.1
 */
public class BizException extends RuntimeException {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}

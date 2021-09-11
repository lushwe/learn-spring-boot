package com.lushwe.dubbo.provider.exception;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2021-09-11 11:43
 * @since 0.1
 */
public class BizException extends RuntimeException {

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }
}

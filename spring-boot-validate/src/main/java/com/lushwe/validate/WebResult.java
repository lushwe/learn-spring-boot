package com.lushwe.validate;

import lombok.Data;

/**
 * 说明：Web响应结果
 *
 * @author Jack Liu
 * @date 2021-06-24 00:33
 * @since 0.1
 */
@Data
public class WebResult<T> {

    private Integer code;
    private String message;
    private T data;

    public WebResult(T data) {
        this(data, 0, "success");
    }

    public WebResult(Integer code, String message) {
        this(null, code, message);
    }

    private WebResult(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public static <T> WebResult<T> success(T data) {
        return new WebResult<>(data);
    }

    public static <T> WebResult<T> fail(Integer code, String message) {
        return new WebResult<>(code, message);
    }
}

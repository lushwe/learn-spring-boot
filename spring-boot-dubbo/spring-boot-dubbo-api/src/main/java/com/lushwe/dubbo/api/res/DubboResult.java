package com.lushwe.dubbo.api.res;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2021-09-11 11:20
 * @since 0.1
 */
@Getter
@Setter
public class DubboResult<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    private String code;
    private String message;
    private T data;

    public DubboResult() {
    }

    private DubboResult(String code, String message) {
        this(code, message, null);
    }

    private DubboResult(T data) {
        this("0", "success", data);
    }

    private DubboResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> DubboResult success(T data) {
        return new DubboResult(data);
    }

    public static DubboResult fail(String code, String message) {
        return new DubboResult(code, message);
    }
}

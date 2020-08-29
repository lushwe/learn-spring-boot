package com.lushwe.learn.entity;

import lombok.Data;

/**
 * 说明：API返回结果类
 *
 * @author Jack Liu
 * @date 2019/2/28 上午9:37
 * @since 1.0
 */
@Data
public class ApiRes<T> {

    private int code;
    private String msg;
    private T data;

    public static <T> ApiRes<T> success(T data) {
        ApiRes apiRes = new ApiRes();
        apiRes.setCode(200);
        apiRes.setMsg("success");
        apiRes.setData(data);
        return apiRes;
    }

    public static <T> ApiRes<T> fail(int code, String msg) {
        ApiRes apiRes = new ApiRes();
        apiRes.setCode(code);
        apiRes.setMsg(msg);
        return apiRes;
    }
}

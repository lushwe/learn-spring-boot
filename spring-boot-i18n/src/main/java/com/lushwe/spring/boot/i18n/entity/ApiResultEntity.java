package com.lushwe.spring.boot.i18n.entity;

import lombok.Data;

/**
 * 说明：API返回结果类
 *
 * @author Jack Liu
 * @date 2019/2/28 上午9:37
 * @since 1.0
 */
@Data
public class ApiResultEntity<T> {

    private int code;
    private String msg;
    private T data;
}

package com.lushwe.spring.boot.aop.enums;

import lombok.Getter;

/**
 * 说明：操作日志状态枚举
 *
 * @author Jack Liu
 * @date 2018/12/12 下午3:40
 * @since 1.0
 */
public enum OperationLogStatus {

    /**
     * 新建
     */
    NEW(0),

    /**
     * 成功
     */
    SUCCESS(1),

    /**
     * 失败
     */
    FAIL(2);

    @Getter
    private final int value;

    OperationLogStatus(int value) {
        this.value = value;
    }
}
package com.lushwe.spring.boot.aop.enums;

import lombok.Getter;

/**
 * 说明：操作日志类型枚举
 *
 * @author Jack Liu
 * @date 2018/12/12 下午3:03
 * @since 1.0
 */
public enum OperationLogType {

    /**
     * 新增
     */
    INSERT(1),

    /**
     * 更新
     */
    UPDATE(2),

    /**
     * 删除
     */
    DELETE(3),

    /**
     * 查询
     */
    QUERY(4),


    ;

    @Getter
    private final int value;

    OperationLogType(int value) {
        this.value = value;
    }

}

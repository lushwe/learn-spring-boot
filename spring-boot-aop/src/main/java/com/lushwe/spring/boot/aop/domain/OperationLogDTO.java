package com.lushwe.spring.boot.aop.domain;

import com.lushwe.spring.boot.aop.enums.OperationLogStatus;
import com.lushwe.spring.boot.aop.enums.OperationLogType;
import lombok.Data;

/**
 * 说明：操作日志DTO对象
 *
 * @author Jack Liu
 * @date 2018/12/12 下午3:22
 * @since 1.0
 */
@Data
public class OperationLogDTO {

    /**
     * 操作日志流水号
     */
    private String code;

    /**
     * 操作日志类
     *
     * @see OperationLogType
     */
    private Integer type;

    /**
     * 操作日志状态
     *
     * @see OperationLogStatus
     */
    private Integer status;

    /**
     * 操作日志详细信息
     */
    private String detail;

}

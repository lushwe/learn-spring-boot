package com.lushwe.spring.boot.aop.domain;

import lombok.Builder;
import lombok.Data;

/**
 * 说明：操作日志详细信息对象
 *
 * @author Jack Liu
 * @date 2018/12/13 下午8:34
 * @since 1.0
 */
@Data
@Builder
public class OperationLogDetailDTO {

    /**
     * 入参
     */
    private Object in;

    /**
     * 出参
     */
    private Object out;

}
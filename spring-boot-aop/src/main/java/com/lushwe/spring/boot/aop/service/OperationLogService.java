package com.lushwe.spring.boot.aop.service;

import com.lushwe.spring.boot.aop.domain.OperationLogDTO;

/**
 * 说明：操作日志 Service 接口
 *
 * @author Jack Liu
 * @date 2018/12/12 下午3:31
 * @since 1.0
 */
public interface OperationLogService {

    /**
     * 新增操作日志
     *
     * @param operationLogDTO
     * @return
     */
    String insertLog(OperationLogDTO operationLogDTO);

    /**
     * 更新操作日志
     *
     * @param operationLogDTO
     */
    void updateLog(OperationLogDTO operationLogDTO);
}

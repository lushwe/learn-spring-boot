package com.lushwe.spring.boot.aop.service.impl;

import com.alibaba.fastjson.JSON;
import com.lushwe.spring.boot.aop.domain.OperationLogDTO;
import com.lushwe.spring.boot.aop.service.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 说明：操作日志 Service 层实现
 *
 * @author Jack Liu
 * @date 2018/12/13 上午10:42
 * @since 1.0
 */
@Slf4j
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Override
    public String insertLog(OperationLogDTO operationLogDTO) {

        log.info("新增操作日志，日志信息：{}", JSON.toJSONString(operationLogDTO));

        String code = "OPT_LOG_" + System.currentTimeMillis();

        return code;
    }

    @Override
    public void updateLog(OperationLogDTO operationLogDTO) {

        log.info("更新操作日志，日志信息：{}", JSON.toJSONString(operationLogDTO));

    }
}

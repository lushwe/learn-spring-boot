package com.lushwe.spring.boot.aop.config;

import com.lushwe.spring.boot.aop.aspect.OperationLogAspect;
import com.lushwe.spring.boot.aop.service.OperationLogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：操作日志切面配置
 *
 * @author Jack Liu
 * @date 2019-11-01 20:55
 * @since 0.1
 */
@Configuration
public class OperationLogAspectConfig {

    @Bean
    public OperationLogAspect operationLogAspect(OperationLogService operationLogService) {

        return new OperationLogAspect(operationLogService);
    }
}

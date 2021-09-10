package com.lushwe.spring.boot.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.lushwe.spring.boot.aop.annotation.OperationLog;
import com.lushwe.spring.boot.aop.domain.OperationLogDTO;
import com.lushwe.spring.boot.aop.domain.OperationLogDetailDTO;
import com.lushwe.spring.boot.aop.enums.OperationLogStatus;
import com.lushwe.spring.boot.aop.service.OperationLogService;
import com.lushwe.spring.boot.aop.util.AspectUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.Ordered;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Map;

/**
 * 说明：操作日志切面
 *
 * @author Jack Liu
 * @date 2018/12/12 下午3:07
 * @since 1.0
 */
@Slf4j
@Order(value = Ordered.LOWEST_PRECEDENCE - 3)
@Aspect
public class OperationLogAspect {

    private static final ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

    private final OperationLogService operationLogService;

    /**
     * 构造器注入
     *
     * @param operationLogService
     */
    @Autowired
    public OperationLogAspect(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @param operationLog
     * @return
     * @throws Throwable
     */
    @Around("@annotation(operationLog)")
    public Object around(ProceedingJoinPoint joinPoint, OperationLog operationLog) throws Throwable {

        String code = null;
        try {

            executeSpel(joinPoint, operationLog);

            code = insertOperationLog(joinPoint, operationLog);
            Object obj = joinPoint.proceed();
            updateOperationLogToSuccess(joinPoint, obj, code);
            return obj;
        } catch (Throwable e) {
            log.error("操作日志记录切面异常", e);
            updateOperationLogToFail(joinPoint, code);
            throw e;
        }
    }

    private void executeSpel(ProceedingJoinPoint joinPoint, OperationLog operationLog) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(signature.getMethod());
        EvaluationContext context = new StandardEvaluationContext();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(operationLog.id());
        Object value = expression.getValue(context);
        log.info("===========value=========={}", value);
    }

    /**
     * 新增操作日志
     *
     * @param joinPoint
     * @param operationLog
     * @return 日志流水号
     */
    private String insertOperationLog(ProceedingJoinPoint joinPoint, OperationLog operationLog) {

        Map<String, Object> inMap = AspectUtils.getInParam(joinPoint);
        OperationLogDetailDTO detailDTO = OperationLogDetailDTO.builder().in(inMap).build();

        OperationLogDTO operationLogDTO = new OperationLogDTO();
        operationLogDTO.setType(operationLog.type().getValue());
        operationLogDTO.setStatus(OperationLogStatus.NEW.getValue());
        operationLogDTO.setDetail(JSON.toJSONString(detailDTO));
        return operationLogService.insertLog(operationLogDTO);
    }

    /**
     * 更新操作日志状态为成功
     *
     * @param joinPoint
     * @param obj
     * @param code
     */
    private void updateOperationLogToSuccess(ProceedingJoinPoint joinPoint, Object obj, String code) {

        updateOperationLog(joinPoint, obj, code, OperationLogStatus.SUCCESS);
    }

    /**
     * 更新操作日志状态为失败
     *
     * @param joinPoint
     * @param code
     */
    private void updateOperationLogToFail(ProceedingJoinPoint joinPoint, String code) {

        updateOperationLog(joinPoint, null, code, OperationLogStatus.FAIL);
    }

    /**
     * 更新操作日志
     *
     * @param joinPoint
     * @param obj
     * @param code
     * @param operationLogStatus
     */
    private void updateOperationLog(ProceedingJoinPoint joinPoint, Object obj, String code, OperationLogStatus operationLogStatus) {

        Map<String, Object> inMap = AspectUtils.getInParam(joinPoint);
        OperationLogDetailDTO detailDTO = OperationLogDetailDTO.builder().in(inMap).out(obj).build();

        OperationLogDTO operationLogDTO = new OperationLogDTO();
        operationLogDTO.setCode(code);
        operationLogDTO.setStatus(operationLogStatus.getValue());
        operationLogDTO.setDetail(JSON.toJSONString(detailDTO));
        operationLogService.updateLog(operationLogDTO);

    }

}

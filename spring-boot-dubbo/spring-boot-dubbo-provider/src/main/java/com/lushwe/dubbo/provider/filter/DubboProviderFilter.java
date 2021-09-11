package com.lushwe.dubbo.provider.filter;

import com.lushwe.dubbo.api.res.DubboResult;
import com.lushwe.dubbo.provider.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.RpcResult;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-01-20 17:06
 * @since 0.1
 */
@Slf4j
@Activate(group = {Constants.PROVIDER}, order = 1)
public class DubboProviderFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        // 接口调用
        Result result = null;
        try {
            result = invoker.invoke(invocation);
        } catch (Throwable e) {
            log.error("系统异常", e);
            return new RpcResult(DubboResult.fail("9", "系统异常"));
        }
        // 处理异常
        if (result.hasException()) {
            return handleException(result.getException());
        }
        // 正常返回
        return result;
    }

    /**
     * 异常处理
     *
     * @param t
     * @return
     */
    private Result handleException(Throwable t) {
        // 参数校验异常
        if (t instanceof ConstraintViolationException) {
            ConstraintViolationException e = (ConstraintViolationException) t;
            Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
            if (iterator.hasNext()) {
                ConstraintViolation<?> constraintViolation = iterator.next();
                return new RpcResult(DubboResult.fail("1", constraintViolation.getMessage()));
            }
            log.warn("参数校验失败", t);
            return new RpcResult(DubboResult.fail("1", "参数校验失败"));
        }
        // 业务异常
        else if (t instanceof BizException) {
            BizException e = (BizException) t;
            return new RpcResult(DubboResult.fail("2", e.getMessage()));
        }

        // 其他异常
        log.error("系统异常", t);
        return new RpcResult(DubboResult.fail("9", "系统异常"));
    }
}

package com.lushwe.ifelse.manager;

/**
 * 说明：支付渠道接口
 *
 * @author Jack Liu
 * @date 2020-03-28 14:26
 * @since 0.1
 */
public interface PayManager {

    /**
     * 支付处理
     *
     * @param orderInfo
     * @return
     */
    boolean pay(Object orderInfo);
}

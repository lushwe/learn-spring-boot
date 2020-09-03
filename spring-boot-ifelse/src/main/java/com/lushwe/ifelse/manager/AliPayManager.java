package com.lushwe.ifelse.manager;

import org.springframework.stereotype.Component;

/**
 * 说明：支付宝支付逻辑
 *
 * @author Jack Liu
 * @date 2020-03-28 14:35
 * @since 0.1
 */
@Component("payManager2")
public class AliPayManager implements PayManager {

    @Override
    public boolean pay(Object orderInfo) {
        System.out.println("支付宝支付");
        return false;
    }

}

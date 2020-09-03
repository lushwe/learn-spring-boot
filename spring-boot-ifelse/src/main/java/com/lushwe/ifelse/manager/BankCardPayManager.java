package com.lushwe.ifelse.manager;

import org.springframework.stereotype.Component;

/**
 * 说明：银行卡支付逻辑
 *
 * @author Jack Liu
 * @date 2020-03-28 14:42
 * @since 0.1
 */
@Component("payManager3")
public class BankCardPayManager implements PayManager {

    @Override
    public boolean pay(Object orderInfo) {
        System.out.println("银行卡支付");
        return false;
    }

}

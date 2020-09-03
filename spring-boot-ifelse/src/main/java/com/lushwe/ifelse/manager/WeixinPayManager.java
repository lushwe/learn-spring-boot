package com.lushwe.ifelse.manager;

import org.springframework.stereotype.Component;

/**
 * 说明：微信支付逻辑
 *
 * @author Jack Liu
 * @date 2020-03-28 14:34
 * @since 0.1
 */
@Component("payManager1")
public class WeixinPayManager implements PayManager {

    @Override
    public boolean pay(Object orderInfo) {
        System.out.println("微信支付");
        return false;
    }

}

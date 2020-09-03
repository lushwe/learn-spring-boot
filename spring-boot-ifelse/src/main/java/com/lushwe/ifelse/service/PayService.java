package com.lushwe.ifelse.service;

import com.lushwe.ifelse.manager.PayManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 说明：支付业务逻辑层
 *
 * @author Jack Liu
 * @date 2020-03-28 14:37
 * @since 0.1
 */
@Service
public class PayService {

    @Autowired
    private Map<String, PayManager> payManagerMap;

    /**
     * 支付
     *
     * @param orderInfo
     * @param payType
     * @return
     */
    public boolean pay(Object orderInfo, Integer payType) {

        PayManager payManager = payManagerMap.get("payManager" + payType);

        payManager.pay(orderInfo);

        return true;
    }
}

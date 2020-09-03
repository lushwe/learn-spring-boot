package com.lushwe.ifelse.controller;

import com.lushwe.ifelse.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：支付接口层
 *
 * @author Jack Liu
 * @date 2020-03-28 14:25
 * @since 0.1
 */
@RestController
public class PayController {

    @Autowired
    private PayService payService;

    /**
     * 支付接口
     *
     * @return
     */
    @PostMapping("/pay")
    public String pay(Integer payType) {

        payService.pay(new Object(), payType);

        return "SUCCESS";
    }
}

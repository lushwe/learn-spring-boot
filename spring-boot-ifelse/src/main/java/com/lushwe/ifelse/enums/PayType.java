package com.lushwe.ifelse.enums;

/**
 * 说明：支付类型枚举
 *
 * @author Jack Liu
 * @date 2020-03-31 09:49
 * @since 0.1
 */
public enum PayType {

    /**
     *
     */
    WEI_XIN(1, "weixinPayManager"),

    /**
     *
     */
    ALIPAY(2, "aliPayManager"),

    /**
     *
     */
    BANK_CARD(3, "bankCardPayManager"),


    ;

    private final Integer payType;
    private final String beanName;

    PayType(Integer payType, String beanName) {
        this.payType = payType;
        this.beanName = beanName;
    }


}

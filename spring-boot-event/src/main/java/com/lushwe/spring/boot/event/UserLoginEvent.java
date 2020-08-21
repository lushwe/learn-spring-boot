package com.lushwe.spring.boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * 说明：用户登录事件
 *
 * @author Jack Liu
 * @date 2019-08-20 16:14
 * @since 0.1
 */
public class UserLoginEvent extends ApplicationEvent {

    public UserLoginEvent(Object source) {
        super(source);
    }
}

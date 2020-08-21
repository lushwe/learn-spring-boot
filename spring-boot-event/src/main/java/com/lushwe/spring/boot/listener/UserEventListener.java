package com.lushwe.spring.boot.listener;

import com.lushwe.spring.boot.event.UserLoginEvent;
import com.lushwe.spring.boot.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 说明：监听方法一：使用注解方式监听用户事件
 *
 * @author Jack Liu
 * @date 2019-08-20 16:18
 * @since 0.1
 */
@Component
public class UserEventListener {


    @Async
    @EventListener
    public void handleUserRegisterEvent(UserRegisterEvent userRegisterEvent) {

        System.out.println("监听注册事件: " + userRegisterEvent);

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("注册事件处理完成");

        System.out.println("当前监听对象: " + this);
    }

    @Async
    @EventListener
    public void handleUserLoginEvent(UserLoginEvent userLoginEvent) {

        System.out.println("监听登录事件: " + userLoginEvent);

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("登录事件处理完成");

        System.out.println("当前监听对象: " + this);
    }
}

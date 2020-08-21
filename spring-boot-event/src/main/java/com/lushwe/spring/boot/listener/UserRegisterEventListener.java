package com.lushwe.spring.boot.listener;

import com.lushwe.spring.boot.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 说明：监听方法二：通过实现接口 ApplicationListener 监听用户事件
 *
 * @author Jack Liu
 * @date 2020-03-31 14:29
 * @since 0.1
 */
@Component
public class UserRegisterEventListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {

        System.out.println("1监听注册事件: " + event);

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("1注册事件处理完成");

        System.out.println("1当前监听对象: " + this);
    }
}

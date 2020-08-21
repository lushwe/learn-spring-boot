package com.lushwe.spring.boot.listener;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 说明：Spring 上下文关闭事件监听
 *
 * @author Jack Liu
 * @date 2020-06-20 10:07
 * @since 0.1
 */
@Component
public class ContextClosedEventListener {

    @Async
    @EventListener
    public void handleUserRegisterEvent(ContextClosedEvent event) {

        System.out.println("监听事件: " + event);

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("事件处理完成");

        System.out.println("当前监听对象: " + this);
    }
}

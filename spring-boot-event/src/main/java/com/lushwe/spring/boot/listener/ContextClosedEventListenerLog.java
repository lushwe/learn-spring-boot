package com.lushwe.spring.boot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * 说明：监听 Spring 上下文关闭事件，打印日志
 *
 * @author Jack Liu
 * @date 2020-10-14 15:58
 * @since 0.1
 */
@Slf4j
@Component
public class ContextClosedEventListenerLog implements ContextClosedEventListener {

    @Override
    public void executeEvent(ContextClosedEvent event) {

        log.info("监听事件: {}", event);

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("事件处理完成", event);

        log.info("当前监听对象: {}", this);
    }
}

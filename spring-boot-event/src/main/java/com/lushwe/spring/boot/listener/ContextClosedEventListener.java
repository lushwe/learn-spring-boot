package com.lushwe.spring.boot.listener;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * 说明：Spring 上下文关闭事件监听
 *
 * @author Jack Liu
 * @date 2020-06-20 10:07
 * @since 0.1
 */
public interface ContextClosedEventListener {

    /**
     * 处理事件监听
     *
     * @param event
     */
    @Async
    @EventListener
    void executeEvent(ContextClosedEvent event);
}

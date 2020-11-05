package com.lushwe.spi.service;

import org.springframework.context.ApplicationContext;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-11-02 10:59
 * @since 0.1
 */
public interface AppStartService {

    /**
     *
     */
    void run(ApplicationContext context);
}

package com.lushwe.spi.service.impl;

import com.lushwe.spi.service.AppStartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.net.InetAddress;

/**
 * 默认实现
 *
 * @author Jack Liu
 * @date 2020-11-02 11:00
 * @since 0.1
 */
@Slf4j
public class AppStartServiceImpl implements AppStartService {

    @Override
    public void run(ApplicationContext context) {
        System.out.println("执行");
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            log.info("hostName:{}", inetAddress.getHostName());
            log.info("hostAddress:{}", inetAddress.getHostAddress());
        } catch (Exception e) {
            log.error("获取IP地址异常", e);
        }
    }
}

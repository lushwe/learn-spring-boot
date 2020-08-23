package com.lushwe.spring.boot.log.manager;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-08-07 17:22
 * @since 0.1
 */
@Slf4j
@Service
public class LogManager {

    // @Slf4j会在编译期间自动生成下面这句代码
    //private static final Logger log = LoggerFactory.getLogger(LogManager.class);

    public void run() {

        for (int i = 0; i < 100; i++) {
            log.info("运行run方法, i=" + i);
        }
        System.out.println("run运行完成");
    }
}

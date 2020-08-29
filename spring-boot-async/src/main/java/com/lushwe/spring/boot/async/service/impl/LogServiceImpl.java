package com.lushwe.spring.boot.async.service.impl;

import com.lushwe.spring.boot.async.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 说明：日志
 *
 * @author Jack Liu
 * @date 2019-06-12 13:38
 * @since 1.0
 */
@Slf4j
@Service
public class LogServiceImpl implements LogService {


    @Async // 异步执行
    @Override
    public void save() {

        log.info("记录日志, start");

        System.out.println(1 / 0);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("记录日志, end.");
    }
}

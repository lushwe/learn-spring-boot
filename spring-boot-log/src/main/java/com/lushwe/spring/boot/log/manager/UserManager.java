package com.lushwe.spring.boot.log.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-05-07 19:22
 * @since 1.0
 */
@Slf4j
@Service
public class UserManager {

    public void run() {

        log.debug("运行run方法");
        log.info("运行run方法");

    }

}

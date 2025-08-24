package com.lushwe.learn.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 心跳示例
 *
 * @author liusw
 * @version V1.0
 * @since 5/13/22 10:42 AM
 */
@Slf4j
@Component
public class HeartbeatJob {

    @XxlJob("heartbeatHandler")
    public void heartbeatHandler() throws Exception {

        for (int i = 0; i < 10; i++) {
            log.info("心跳...., i=" + i);
            Thread.sleep(3000L);
        }
    }
}

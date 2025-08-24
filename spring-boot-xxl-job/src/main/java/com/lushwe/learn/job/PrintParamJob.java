package com.lushwe.learn.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 打印参数示例
 *
 * @author liusw
 * @version V1.0
 * @since 5/16/22 3:55 PM
 */
@Slf4j
@Component
public class PrintParamJob {

    @XxlJob("printParamJob")
    public void execute() {

        String param = XxlJobHelper.getJobParam();

        log.info("打印参数, param:{}", param);
    }
}

package com.lushwe.dubbo.consumer.service;

import com.alibaba.fastjson.JSON;
import com.lushwe.dubbo.api.DemoService;
import com.lushwe.dubbo.api.req.DemoReq;
import com.lushwe.dubbo.api.res.DemoRes;
import com.lushwe.dubbo.api.res.DubboResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2021-09-10 23:47
 * @since 0.1
 */
@Slf4j
@Component
public class TestService {

    @Reference(retries = 0)
    private DemoService demoService;

    public void test() {

        DemoReq req = new DemoReq();
        req.setId(1L);
        req.setName("99");
        req.setIds(Arrays.asList(1L, 2L, 3L, 4L));

        DubboResult<DemoRes> result = demoService.getDemo(req);

        log.info("响应结果:{}", JSON.toJSONString(result));
    }
}

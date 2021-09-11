package com.lushwe.dubbo.provider.api.impl;

import com.alibaba.fastjson.JSON;
import com.lushwe.dubbo.api.DemoService;
import com.lushwe.dubbo.api.req.DemoReq;
import com.lushwe.dubbo.api.res.DemoRes;
import com.lushwe.dubbo.api.res.DubboResult;
import com.lushwe.dubbo.provider.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2021-09-10 23:10
 * @since 0.1
 */
@Slf4j
@Service(validation = "true")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return null;
    }

    @Override
    public DubboResult<DemoRes> getDemo(DemoReq req) {

        log.info("请求参数:{}", JSON.toJSONString(req));

        if (req.getId() == -1) {
            throw new BizException("信息处理失败");
        }

        System.out.println(1 / req.getId());

        DemoRes res = new DemoRes();
        res.setId(req.getId());
        res.setName(req.getName());
        res.setAge(24);

        return DubboResult.success(res);
    }
}

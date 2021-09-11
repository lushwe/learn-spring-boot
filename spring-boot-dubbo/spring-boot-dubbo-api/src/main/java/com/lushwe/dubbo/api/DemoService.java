package com.lushwe.dubbo.api;

import com.lushwe.dubbo.api.req.DemoReq;
import com.lushwe.dubbo.api.res.DemoRes;
import com.lushwe.dubbo.api.res.DubboResult;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-07-19 21:25
 * @since 0.1
 */
public interface DemoService {

    String sayHello(String name);

    DubboResult<DemoRes> getDemo(DemoReq req);

}

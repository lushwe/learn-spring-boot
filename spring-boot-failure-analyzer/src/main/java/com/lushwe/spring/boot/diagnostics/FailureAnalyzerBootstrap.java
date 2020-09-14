package com.lushwe.spring.boot.diagnostics;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 说明：启动类
 *
 * @author Jack Liu
 * @date 2019-06-16 17:46
 * @since 1.0
 */
//@SpringBootApplication
public class FailureAnalyzerBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Object.class)
                .initializers(context -> {
                    throw new UnknownError("故意抛出异常");
                })
                .web(WebApplicationType.NONE)
                .run(args)
                .close();
    }
}

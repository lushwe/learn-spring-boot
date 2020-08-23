package com.lushwe.spring.boot.log;

import com.lushwe.spring.boot.log.manager.LogManager;
import com.lushwe.spring.boot.log.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 说明：应用启动类
 *
 * @author Jack Liu
 * @date 2019-05-07 19:18
 * @since 1.0
 */
@Slf4j
@SpringBootApplication
public class LogBootstrap {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            System.out.println(s);
        }

        MDC.put("TRACE_ID", UUID.randomUUID().toString());

        ConfigurableApplicationContext context = SpringApplication.run(LogBootstrap.class, args);

        UserManager userManager = context.getBean(UserManager.class);
        userManager.run();
        LogManager logManager = context.getBean(LogManager.class);
        logManager.run();

        MDC.get("TRACE_ID");

        log.info("当前线程打印日志");

        MDC.remove("TRACE_ID");

    }
}

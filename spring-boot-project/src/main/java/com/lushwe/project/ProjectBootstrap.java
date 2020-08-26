package com.lushwe.project;

import com.lushwe.project.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * 说明：启动类
 *
 * @author Jack Liu
 * @date 2020-08-26 13:31
 * @since 0.1
 */
@SpringBootApplication
public class ProjectBootstrap {

    @Autowired
    private UserManager userManager;

    public static void main(String[] args) {

        SpringApplication.run(ProjectBootstrap.class, args);

    }

    @Component
    class TestRunner implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) throws Exception {
            Object user = userManager.findUser(null);
            System.out.println(user);
        }
    }
}

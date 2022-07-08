package com.lushwe.learn.tx;

import com.lushwe.learn.tx.model.UserDO;
import com.lushwe.learn.tx.process.UserProcess;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 */
@MapperScan("com.lushwe.learn.tx.dao")
@SpringBootApplication
public class TxApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TxApplication.class, args);
        UserProcess userProcess = context.getBean(UserProcess.class);

        UserDO one = new UserDO();
        one.setId(1L);
        one.setUserName("zhangsan_11");

        UserDO two = new UserDO();
        two.setId(2L);
        two.setUserName("zhangsan_22");
        userProcess.updateRequiredAndRequired(one, two);
//        userProcess.updateForRequiredNew(userDO);
//        userProcess.updateRequiredAndNested(userDO, userDO2);
        System.out.println("Hello World!");
    }
}

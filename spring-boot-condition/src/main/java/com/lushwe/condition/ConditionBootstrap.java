package com.lushwe.condition;

import com.lushwe.condition.bean.Person;
import com.lushwe.condition.config.PersonConfig;
import com.lushwe.condition.one.OneBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-03-31 11:09
 * @since 0.1
 */
@SpringBootApplication(scanBasePackages = "com.lushwe.condition.one")
public class ConditionBootstrap {

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.getEnvironment().getSystemProperties().put("person", "mother");
//        ctx.register(PersonConfig.class);
//        ctx.refresh();
//
//        System.out.println(ctx.getBean("person", Person.class).getName());


        ConfigurableApplicationContext context = SpringApplication.run(ConditionBootstrap.class, args);
        OneBean oneBean1 = context.getBean("oneBean1", OneBean.class);
        System.out.println(oneBean1);

        OneBean oneBean2 = context.getBean("oneBean2", OneBean.class);
        System.out.println(oneBean2);
    }
}

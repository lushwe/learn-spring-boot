package com.lushwe.condition.config;

import com.lushwe.condition.bean.Father;
import com.lushwe.condition.bean.Mother;
import com.lushwe.condition.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-03-31 11:14
 * @since 0.1
 */
@Configuration
public class PersonConfig {


    @Bean("person")
    @Conditional(FatherCondition.class)
    public Person father() {
        return new Father();
    }

    @Bean("person")
    @Conditional(MotherCondition.class)
    public Person mother() {
        return new Mother();
    }
}

package com.lushwe.condition;

import com.lushwe.condition.one.OneBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 说明：测试 @ConditionalOnProperty
 *
 * @author Jack Liu
 * @date 2020-08-10 14:13
 * @since 0.1
 */
@SpringBootApplication(scanBasePackages = "com.lushwe.condition.one")
public class ConditionalOnPropertyTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConditionalOnPropertyTest.class, args);
        OneBean oneBean = context.getBean(OneBean.class);
        System.out.println(oneBean);

        // ConditionalOnProperty使用总结
        // prefix属性值用于匹配配置前缀
        // one属性值用于匹配配置名称

        // havingValue用于判断条件注解为true还是false
        // 如果指定的配置值与havingValue相等则条件注解为true，不等则条件注解为false

        // matchIfMissing指定没有该配置值时，条件注解为true还是false（默认为false）
        // 如果matchIfMissing设置为false，表示：如果没有该配置值，则条件注解直接false；如果有该配置值，则需要与havingValue比较，配置与havingValue相同，条件注解为true，否则条件注解为false
        // 如果matchIfMissing设置为true，表示：如果没有该配置值，则条件注解直接true；如果有该配置值，则需要与havingValue比较，配置与havingValue相同，条件注解为true，否则条件注解为false


        // ConditionalOnClass使用总结
        // 如果类路径下包含指定的类，自动配置才会生效
    }
}

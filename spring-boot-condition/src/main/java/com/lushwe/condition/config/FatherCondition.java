package com.lushwe.condition.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-03-31 11:12
 * @since 0.1
 */
public class FatherCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("person").equals("father");
    }
}

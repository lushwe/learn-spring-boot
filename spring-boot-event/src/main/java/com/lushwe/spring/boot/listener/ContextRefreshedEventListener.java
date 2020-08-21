package com.lushwe.spring.boot.listener;

import com.alibaba.fastjson.JSON;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 说明：Spring 上下文刷新事件监听
 *
 * @author Jack Liu
 * @date 2020-07-30 14:11
 * @since 0.1
 */
@Component
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Spring 上下文刷新事件监听");
        System.out.println("context-->" + event.getApplicationContext());
        System.out.println("source-->" + event.getSource());
        System.out.println("timestamp-->" + event.getTimestamp());


        ApplicationContext applicationContext = event.getApplicationContext();

        String[] annotationArr = applicationContext.getBeanNamesForAnnotation(RestController.class);
        Map<String, Object> annotationMap = applicationContext.getBeansWithAnnotation(RestController.class);

        System.out.println(JSON.toJSONString(annotationArr, true));
        System.out.println(JSON.toJSONString(annotationMap, true));


        for (Map.Entry<String, Object> entry : annotationMap.entrySet()) {

            // 查找Bean上的注解
            RestController annotationOnBean = applicationContext.findAnnotationOnBean(entry.getKey(), RestController.class);

            // 去除代理
            Class clazz;
            if (AopUtils.isAopProxy(entry.getValue())) {
                clazz = AopUtils.getTargetClass(entry.getValue());
            } else {
                clazz = entry.getValue().getClass();
            }

            // 查询类上的注解
            RestController annotationOnClass = (RestController) clazz.getAnnotation(RestController.class);

            if (annotationOnClass == null) {
                clazz = clazz.getInterfaces()[0];
            }

            System.out.println("clazz-->" + clazz);
        }

    }
}

package com.lushwe.spi;

import com.lushwe.spi.service.AppStartService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-11-02 10:53
 * @since 0.1
 */
@Component
public class ApplicationEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ServiceLoader<AppStartService> serviceLoader = ServiceLoader.load(AppStartService.class);
        Iterator<AppStartService> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            AppStartService startService = iterator.next();
            startService.run(event.getApplicationContext());
        }
    }
}

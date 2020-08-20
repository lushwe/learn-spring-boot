package com.lushwe.es;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 说明：应用启动类
 *
 * @author Jack Liu
 * @date 2019-05-07 19:18
 * @since 1.0
 */
@SpringBootApplication
public class Application {

    @Autowired
    private StoreService storeService;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    @Component
    class StoreRunner implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) {

            Store store = storeService.findById("9012");
            System.out.println(JSON.toJSONString(store, true));

            Page<Store> page = storeService.search();
            System.out.println(JSON.toJSONString(page, true));


            List<Store> storeList = storeService.textSearch("分公司");
            System.out.println(JSON.toJSONString(storeList, true));

            Page<Store> storePage = storeService.textSearchForPage("分公司");
            System.out.println(JSON.toJSONString(storePage, true));

            store = new Store();
            store.setStoreCode("9012");
            store.setStoreName("经年1");
            store.setCityCode("0571");
            store.setOrgName("江陵1");
            store.setOwner("江陵1");
            store.setAddress("滨江滨和1");
            Store dbStore = storeService.update(store);

            System.out.println(JSON.toJSONString(dbStore, true));
        }
    }

}

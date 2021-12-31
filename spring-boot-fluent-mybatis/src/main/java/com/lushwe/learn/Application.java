package com.lushwe.learn;

import com.alibaba.fastjson.JSON;
import com.lushwe.learn.dal.entity.UserEntity;
import com.lushwe.learn.dal.mapper.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * 启动类
 *
 * @author Jack
 * @version V1.0
 * @since 7/13/21 5:56 PM
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        UserMapper userMapper = context.getBean(UserMapper.class);

        // delete
        int delete = userMapper.delete(userMapper.query().where.user_id().eq("1").end());
        System.out.println(delete);

        // insert
        UserEntity entity = new UserEntity();
        entity.setUser_id("1");
        entity.setUser_name("test");
        entity.setPassword("xxx");
        entity.setDel_flag(0);
        int insert = userMapper.insert(entity);
        System.out.println(insert);

        // findOne
        UserEntity userEntity = userMapper.findOne(userMapper.query()
                .where.id().eq(1L)
                .and.del_flag().eq(0)
                .end());
        System.out.println(JSON.toJSONString(userEntity));

        // listEntity
        List<UserEntity> userEntities = userMapper.listEntity(userMapper.query()
                .where.user_id().eq("1")
                .and.del_flag().eq(0)
                .end());
        System.out.println(JSON.toJSONString(userEntities));
    }
}

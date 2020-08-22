package com.lushwe.mybatis;

import com.alibaba.fastjson.JSON;
import com.lushwe.mybatis.dao.UserDAO;
import com.lushwe.mybatis.model.UserDO;
import com.lushwe.mybatis.qo.UserQO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 说明：启动类
 *
 * @author Jack Liu
 * @date 2020-08-22 12:23
 * @since 0.1
 */
@MapperScan("com.lushwe.mybatis.dao")
@SpringBootApplication
public class MybatisBootstrap {

    @Resource
    private UserDAO userDAO;

    public static void main(String[] args) {

        SpringApplication.run(MybatisBootstrap.class, args);

    }

    @Component
    class DAORuner implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) throws Exception {

            String userId = System.currentTimeMillis() + "";

            // 新增
            UserDO insert = new UserDO();
            insert.setUserId(userId);
            insert.setUserName("zhaoliu");
            insert.setPassword("123456");
            insert.setStatus(1);
            insert.setMemo("测试");
            int result = userDAO.insert(insert);
            System.out.println(result);

            // 更新
            UserDO update = new UserDO();
            update.setUserId(userId);
            update.setUserName("zhaoliu1");
            update.setPassword("1234561");
            update.setStatus(0);
            update.setMemo("测试1");
            int result2 = userDAO.update(update);
            System.out.println(result2);

            // 查询对象
            UserDO userDO = userDAO.findById(userId);
            System.out.println(JSON.toJSONString(userDO, true));

            // 查询列表
            UserQO userQO = new UserQO();
            userQO.setUserId(userId);
            List<UserDO> userDOList = userDAO.findListByQO(userQO);
            System.out.println(JSON.toJSONString(userDOList, true));
        }
    }
}

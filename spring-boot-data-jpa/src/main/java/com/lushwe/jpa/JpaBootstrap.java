package com.lushwe.jpa;

import com.alibaba.fastjson.JSON;
import com.lushwe.jpa.dao.SysUserDAO;
import com.lushwe.jpa.dataobject.SysUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-08-12 20:59
 * @since 0.1
 */
@SpringBootApplication
public class JpaBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JpaBootstrap.class, args);

        SysUserDAO sysUserDAO = context.getBean(SysUserDAO.class);

        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        sysUser.setUserId("lisi");
        sysUser.setUserName("李四");
        sysUser.setPassword("123456");
        sysUser.setStatus(1);
        sysUser.setRemark("测试JPA");
        sysUser.setDelFlag(0);
        SysUser dbSysUser = sysUserDAO.save(sysUser);
        System.out.println(JSON.toJSONString(dbSysUser, true));

        Optional<SysUser> optionalSysUser = sysUserDAO.findById(1L);
        System.out.println(JSON.toJSONString(optionalSysUser.orElse(null), true));

        Optional<SysUser> optionalSysUser2 = sysUserDAO.findById(11L);
        System.out.println(JSON.toJSONString(optionalSysUser2.orElse(null), true));
    }
}

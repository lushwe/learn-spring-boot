package com.lushwe.jpa;

import com.alibaba.fastjson.JSON;
import com.lushwe.jpa.dao.SysUserDAO;
import com.lushwe.jpa.dataobject.SysUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * 说明：启动类
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

        // save
//        System.out.println("===新增===");
//        SysUser sysUser = new SysUser();
//        sysUser.setId(4L);
//        sysUser.setUserId("lisi");
//        sysUser.setUserName("李四");
//        sysUser.setPassword("123456");
//        sysUser.setStatus(1);
//        sysUser.setRemark("测试JPA");
//        sysUser.setDelFlag(0);
//        SysUser dbSysUser = sysUserDAO.save(sysUser);
//        System.out.println(JSON.toJSONString(dbSysUser, true));

        // findById
        System.out.println("===查询===");
        Optional<SysUser> optionalSysUser = sysUserDAO.findById(1L);
        System.out.println(JSON.toJSONString(optionalSysUser.orElse(null), true));

        // findAll
        System.out.println("===列表===");
        SysUser user1 = new SysUser();
        user1.setUserId("lisi");
        List<SysUser> sysUserList = sysUserDAO.findAll(Example.of(user1));
        System.out.println(JSON.toJSONString(sysUserList, true));

        // findAll
        System.out.println("===排序===");
        List<SysUser> sysUserList2 = sysUserDAO.findAll(Sort.by(Sort.Order.asc("userId"), Sort.Order.desc("updateTime")));
        System.out.println(JSON.toJSONString(sysUserList2, true));

        // findAll
        System.out.println("===分页+排序===");
        Sort sort = Sort.by(Sort.Order.asc("userId"), Sort.Order.desc("createTime"));
        Page<SysUser> page = sysUserDAO.findAll(Example.of(user1), PageRequest.of(0, 2, sort));
        System.out.println(JSON.toJSONString(page, true));
    }
}

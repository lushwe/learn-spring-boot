package com.lushwe.spring.boot.aop.service.impl;

import com.alibaba.fastjson.JSON;
import com.lushwe.spring.boot.aop.domain.UserDTO;
import com.lushwe.spring.boot.aop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 说明：测试缓存切面业务
 *
 * @author Jack Liu
 * @date 2019-11-01 16:17
 * @since 0.1
 */
@Slf4j
@Component
public class UserServiceImpl implements UserService {

    @Override
    public void insertUser(UserDTO userDTO) {

        log.info("新增用户，请求参数：{}", JSON.toJSONString(userDTO));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {

        log.info("更新用户，请求参数：{}", JSON.toJSONString(userDTO));

        UserDTO resUserDTO = new UserDTO();
        resUserDTO.setId(userDTO.getId());
        resUserDTO.setName(userDTO.getName());
        return resUserDTO;
    }

    @Override
    public void deleteUser(Long id) {

        log.info("删除用户，用户ID[{}]", id);
    }

    @Override
    public UserDTO findUserById(Long userId) {

        log.info("根据用户ID查询用户信息, userId={}", userId);

        UserDTO user = new UserDTO();
        user.setId(userId);
        user.setName("测试");
        user.setAge(24);
        user.setTimestamp(System.currentTimeMillis());

        return user;
    }


}

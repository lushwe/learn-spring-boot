package com.lushwe.spring.boot.aop.service.impl;

import com.alibaba.fastjson.JSON;
import com.lushwe.spring.boot.aop.annotation.OperationLog;
import com.lushwe.spring.boot.aop.domain.UserBO;
import com.lushwe.spring.boot.aop.domain.UserDTO;
import com.lushwe.spring.boot.aop.enums.OperationLogType;
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

    public static final String KEY_SEP = "#";

    @OperationLog(type = OperationLogType.INSERT)
    @Override
    public void insertUser(UserDTO userDTO) {

        log.info("新增用户，请求参数：{}", JSON.toJSONString(userDTO));
    }

    @OperationLog(type = OperationLogType.UPDATE, id = "#userDTO")
    @Override
    public UserDTO updateUser(UserDTO userDTO) {

        log.info("更新用户，请求参数：{}", JSON.toJSONString(userDTO));

        UserDTO resUserDTO = new UserDTO();
        resUserDTO.setId(userDTO.getId());
        resUserDTO.setName(userDTO.getName());
        return resUserDTO;
    }

    @OperationLog(type = OperationLogType.UPDATE, id = "#userBO.userDTO.name")
    @Override
    public UserDTO updateUserTwo(UserDTO userDTO, UserBO userBO) {

        log.info("更新用户，请求参数：{}", JSON.toJSONString(userDTO));

        return null;
    }

    @OperationLog(type = OperationLogType.UPDATE, id = "T(com.lushwe.spring.boot.aop.service.impl.UserServiceImpl).KEY_SEP")
    @Override
    public UserDTO updateUserThree(UserDTO userDTO, UserBO userBO) {

        log.info("更新用户，请求参数：{}", JSON.toJSONString(userDTO));

        return null;
    }

    @OperationLog(type = OperationLogType.DELETE)
    @Override
    public void deleteUser(Long id) {

        log.info("删除用户，用户ID[{}]", id);
    }

    @OperationLog(type = OperationLogType.QUERY)
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

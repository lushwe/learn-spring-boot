package com.lushwe.spring.boot.aop.service;

import com.lushwe.spring.boot.aop.domain.UserBO;
import com.lushwe.spring.boot.aop.domain.UserDTO;

/**
 * 说明：用户 Service 接口
 *
 * @author Jack Liu
 * @date 2019-11-01 16:16
 * @since 0.1
 */
public interface UserService {

    /**
     * 新增用户
     *
     * @param userDTO
     */
    void insertUser(UserDTO userDTO);

    /**
     * 更新用户
     *
     * @param userDTO
     * @return
     */
    UserDTO updateUser(UserDTO userDTO);

    UserDTO updateUserTwo(UserDTO userDTO, UserBO userBO);

    UserDTO updateUserThree(UserDTO userDTO, UserBO userBO);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId
     * @return
     */
    UserDTO findUserById(Long userId);
}

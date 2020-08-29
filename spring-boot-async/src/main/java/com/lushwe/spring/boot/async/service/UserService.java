package com.lushwe.spring.boot.async.service;

import com.lushwe.spring.boot.common.dto.UserDTO;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-06-12 13:30
 * @since 1.0
 */
public interface UserService {

    /**
     * 新增
     *
     * @param userDTO
     */
    void insert(UserDTO userDTO);


    /**
     * @param id
     * @return
     */
    UserDTO getById(Long id);
}

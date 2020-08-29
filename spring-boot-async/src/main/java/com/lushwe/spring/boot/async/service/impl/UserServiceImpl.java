package com.lushwe.spring.boot.async.service.impl;

import com.lushwe.spring.boot.async.service.LogService;
import com.lushwe.spring.boot.async.service.UserService;
import com.lushwe.spring.boot.common.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明：用户
 *
 * @author Jack Liu
 * @date 2019-06-12 13:37
 * @since 1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LogService logService;


    @Override
    public void insert(UserDTO userDTO) {

        log.info("新增用户");

        logService.save();

    }

    @Override
    public UserDTO getById(Long id) {

        log.info("查询用户");

        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);

        logService.save();

        return userDTO;
    }
}

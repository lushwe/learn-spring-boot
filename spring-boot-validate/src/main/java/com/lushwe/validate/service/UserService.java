package com.lushwe.validate.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-07-19 13:35
 * @since 0.1
 */
@Validated
@Service
public class UserService {

    public User insertUser(@Valid @NotNull(message = "不能为空") User user) {

        return user;
    }
}

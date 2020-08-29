package com.lushwe.spring.boot.async.controller;

import com.lushwe.spring.boot.async.service.UserService;
import com.lushwe.spring.boot.common.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：用户
 *
 * @author Jack Liu
 * @date 2019-06-12 14:18
 * @since 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void insert() {

    }


    @GetMapping("/users/{id}")
    public UserDTO get(@PathVariable("id") Long id) {

        return userService.getById(id);

    }
}

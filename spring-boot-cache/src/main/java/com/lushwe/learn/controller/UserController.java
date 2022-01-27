package com.lushwe.learn.controller;

import com.lushwe.learn.dto.UserDTO;
import com.lushwe.learn.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO 写点注释吧
 *
 * @author liusw
 * @version V1.0
 * @since 1/14/22 5:57 PM
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/users/{id}")
    public UserDTO findById(@PathVariable("id") Long id) {

        UserDTO param = new UserDTO();
        param.setId(id);

        UserDTO userDTO = userService.findById(id);

        return userDTO;

    }

    @GetMapping("/users/redis/{id}")
    public UserDTO findByIdRedis(@PathVariable("id") Long id) {

        UserDTO param = new UserDTO();
        param.setId(id);

        UserDTO userDTO = userService.findById(param);

        return userDTO;

    }
}

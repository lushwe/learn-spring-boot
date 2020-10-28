package com.lushwe.spring.boot.aop.controller;

import com.lushwe.spring.boot.aop.domain.UserDTO;
import com.lushwe.spring.boot.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-11-01 19:58
 * @since 0.1
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserDTO findUserById(@PathVariable Long id) {

        return userService.findUserById(id);
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody UserDTO userDTO) {

        userService.insertUser(userDTO);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {

        userDTO.setId(id);
        userService.updateUser(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {

        userService.deleteUser(id);
    }
}

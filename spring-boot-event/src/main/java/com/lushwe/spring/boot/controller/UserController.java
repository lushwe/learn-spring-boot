package com.lushwe.spring.boot.controller;

import com.lushwe.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-03-31 14:31
 * @since 0.1
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/event/register")
    public String publishRegisterEvent() {

        userService.register();

        return "register";
    }

    @GetMapping("/event/login")
    public String publishLoginEvent() {

        userService.login();

        return "login";
    }
}

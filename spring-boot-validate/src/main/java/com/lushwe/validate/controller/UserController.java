package com.lushwe.validate.controller;

import com.lushwe.validate.dto.UserReq;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @author Jack Liu
 * @date 2019/9/1 19:55
 */
@Validated
@RestController
public class UserController {

    @GetMapping(value = "/users")
    public String listUsers(@Valid UserReq userReq, Errors errors) {
        return "[]";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@Min(value = 0, message = "参数不合法") @PathVariable("id") Long id) {
        return "zhangsan";
    }

    @PostMapping(value = "/users")
    public String insertUser(@Valid @RequestBody UserReq userReq, Errors errors) {
        return "success";
    }

}

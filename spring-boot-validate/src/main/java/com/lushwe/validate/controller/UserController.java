package com.lushwe.validate.controller;

import com.lushwe.validate.dto.UserReq;
import com.lushwe.validate.group.Insert;
import com.lushwe.validate.group.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

/**
 * @author Jack Liu
 * @date 2019/9/1 19:55
 */
@Validated
@RestController
public class UserController {

    @GetMapping(value = "/users")
    public String listUsers(UserReq userReq) {
        return "[]";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@Min(value = 0, message = "ID参数不合法") @PathVariable("id") Long id) {
        return "zhangsan";
    }

    @PostMapping(value = "/users")
    public String insertUser(@Validated(Insert.class) @RequestBody UserReq userReq) {
        return "success";
    }

    @PutMapping(value = "/users")
    public String updateUser(@Validated(Update.class) @RequestBody UserReq userReq) {
        return "success";
    }
}

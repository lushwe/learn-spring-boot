package com.lushwe.learn.controller;

import com.lushwe.learn.dto.UserReq;
import com.lushwe.learn.entity.ApiRes;
import org.springframework.util.Assert;
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
 * @date 2018/9/1 19:55
 */
@Validated
@RestController
public class UserController {

    @GetMapping(value = "/users")
    public ApiRes<String> listUsers(@Valid UserReq userReq, Errors errors) {

        Assert.notNull(userReq, "userReq对象不能为空");
        Assert.notNull(userReq.getUserName(), "userName不能为空");

        return ApiRes.success("[]");
    }

    @GetMapping("/users/{id}")
    public ApiRes<String> getUserById(@Min(value = 0, message = "参数不合法") @PathVariable("id") Long id) {
        return ApiRes.success("zhangsan");
    }

    @PostMapping(value = "/users")
    public ApiRes<String> insertUser(@Valid @RequestBody UserReq userReq, Errors errors) {
        return ApiRes.success("success");
    }

}

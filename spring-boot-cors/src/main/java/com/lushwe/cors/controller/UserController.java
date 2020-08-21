package com.lushwe.cors.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-11-21 19:55
 * @since 0.1
 */
//@CrossOrigin(methods = {RequestMethod.GET})
@RestController
public class UserController {

    @GetMapping("/users")
    public List<String> listUsers() {
        return Collections.emptyList();
    }


    @PutMapping("/users/{id}")
    public Boolean listUsers(@PathVariable("id") Long id) {
        return true;
    }
}

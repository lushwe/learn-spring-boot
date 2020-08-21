package com.lushwe.cors.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-11-21 19:45
 * @since 0.1
 */
//@CrossOrigin
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {

        return "Hello World !";
    }
}

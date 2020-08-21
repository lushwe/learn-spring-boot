package com.lushwe.spring.boot.service;

import com.lushwe.spring.boot.event.UserLoginEvent;
import com.lushwe.spring.boot.event.UserRegisterEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 说明：用户
 *
 * @author Jack Liu
 * @date 2019-08-20 16:26
 * @since 0.1
 */
@Service
public class UserServiceImpl implements UserService {

    private final ApplicationEventPublisher applicationEventPublisher;

    public UserServiceImpl(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @Override
    public void register() {

        System.out.println("注册开始");

        applicationEventPublisher.publishEvent(new UserRegisterEvent(this));

        System.out.println("注册结束");
    }

    @Override
    public void login() {

        System.out.println("登录开始");

        applicationEventPublisher.publishEvent(new UserLoginEvent(this));

        System.out.println("登录结束");
    }
}

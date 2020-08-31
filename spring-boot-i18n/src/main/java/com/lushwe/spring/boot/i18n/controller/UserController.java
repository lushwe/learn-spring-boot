package com.lushwe.spring.boot.i18n.controller;

import com.lushwe.spring.boot.common.dto.UserDTO;
import com.lushwe.spring.boot.i18n.entity.ApiResultEntity;
import com.lushwe.spring.boot.i18n.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.action.GetPropertyAction;

import java.security.AccessController;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-08-24 15:06
 * @since 0.1
 */
@Slf4j
@Validated
@RestController
public class UserController {


    @GetMapping("/demo")
    public ApiResultEntity<Boolean> demo(UserDTO userDTO) {

        // 获取计算机属性
        String name = AccessController.doPrivileged(new GetPropertyAction("user.name", ""));
        String language = AccessController.doPrivileged(new GetPropertyAction("user.language", "en"));
        String region = AccessController.doPrivileged(new GetPropertyAction("user.region"));
        String script = AccessController.doPrivileged(new GetPropertyAction("user.script", ""));
        String country = AccessController.doPrivileged(new GetPropertyAction("user.country", ""));
        String variant = AccessController.doPrivileged(new GetPropertyAction("user.variant", ""));

        log.info("name:{}, language:{}, region:{}, script:{}, country:{}, variant:{}", name, language, region, script, country, variant);

        if (1 > 0) {
            throw new BizException(1, "业务异常");
        }

        System.out.println(1 / 0);

        return new ApiResultEntity<>();
    }
}

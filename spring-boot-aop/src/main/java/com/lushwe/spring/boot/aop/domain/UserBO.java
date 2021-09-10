package com.lushwe.spring.boot.aop.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2021-08-20 23:04
 * @since 0.1
 */
@Getter
@Setter
public class UserBO {

    private Long id;
    private String name;
    private Integer age;
    private Long timestamp;

    private UserDTO userDTO;
}

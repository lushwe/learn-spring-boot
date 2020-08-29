package com.lushwe.learn.service;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-07-19 13:36
 * @since 0.1
 */
@Data
public class User {

    @NotBlank(message = "不能为空")
    private String userName;
}

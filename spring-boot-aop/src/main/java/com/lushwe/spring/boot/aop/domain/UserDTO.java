package com.lushwe.spring.boot.aop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 说明：用户DTO对象
 *
 * @author Jack Liu
 * @date 2018/12/13 上午10:47
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDTO {

    private Long id;
    private String name;
    private Integer age;
    private Long timestamp;
}

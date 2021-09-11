package com.lushwe.dubbo.api.res;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 说明：DemoRes
 *
 * @author Jack Liu
 * @date 2021-09-10 23:12
 * @since 0.1
 */
@Getter
@Setter
public class DemoRes implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * id
     */
    private Long id;

    /**
     * name
     */
    private String name;

    /**
     * age
     */
    private Integer age;
}

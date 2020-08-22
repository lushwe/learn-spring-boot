package com.lushwe.mybatis.model;

import lombok.Data;

import java.util.Date;

/**
 * 说明：用户DO
 *
 * @author Jack Liu
 * @date 2020-08-22 12:59
 * @since 0.1
 */
@Data
public class UserDO {

    /**
     * 设置主键自增
     */
    private Integer id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 0-无效，1-有效
     */
    private Integer status;

    /**
     * 备注
     */
    private String memo;

    /**
     * 删除标识，0-未删除，1-已删除
     */
    private Integer delFlag;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 记录最近更新时间
     */
    private Date updateTime;
}

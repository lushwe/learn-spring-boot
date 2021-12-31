package com.lushwe.learn.dal.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * UserEntity
 *
 * @author liusw
 * @version V1.0
 * @since 12/31/21 1:46 PM
 */
@Getter
@Setter
@FluentMybatis(table = "t_user", schema = "dev")
public class UserEntity extends RichEntity {

    private Long id;
    private String userId;
    private String userName;
    private String password;
    private String status;
    private String memo;
    private Integer delFlag;
    private Date createTime;
    private Date updateTime;
}

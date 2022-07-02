package com.lushwe.learn.dal.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * TODO 写点注释吧
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
    private String user_id;
    private String user_name;
    private String password;
    private String status;
    private String memo;
    private Integer del_flag;
    private Date create_time;
    private Date update_time;
}

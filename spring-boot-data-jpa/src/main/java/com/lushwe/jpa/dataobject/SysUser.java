package com.lushwe.jpa.dataobject;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-08-12 21:05
 * @since 0.1
 */
@Setter
@Getter
@Entity
@Table(name = "t_user")
public class SysUser {

    /**
     * 注解
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 状态
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 备注
     */
    @Column(name = "memo")
    private String remark;

    private Integer delFlag;

    private Date createTime;

    private Date updateTime;
}

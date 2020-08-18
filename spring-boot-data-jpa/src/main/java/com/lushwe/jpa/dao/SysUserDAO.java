package com.lushwe.jpa.dao;

import com.lushwe.jpa.dataobject.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2020-08-12 21:10
 * @since 0.1
 */
public interface SysUserDAO extends JpaRepository<SysUser, Long>, Serializable {
}

package com.lushwe.mybatis.dao;

import com.lushwe.mybatis.model.UserDO;
import com.lushwe.mybatis.qo.UserQO;

import java.util.List;

/**
 * 说明：用户DAO
 *
 * @author Jack Liu
 * @date 2020-08-22 12:27
 * @since 0.1
 */
public interface UserDAO {

    /**
     * 新增
     *
     * @param userDO
     * @return
     */
    int insert(UserDO userDO);

    /**
     * 更新
     *
     * @param userDO
     * @return
     */
    int update(UserDO userDO);

    /**
     * 根据主键查询
     *
     * @param userId
     * @return
     */
    UserDO findById(String userId);

    /**
     * 查询列表
     *
     * @param userQO
     * @return
     */
    List<UserDO> findListByQO(UserQO userQO);
}

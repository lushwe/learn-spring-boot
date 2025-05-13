package com.lushwe.learn.tx.service;

import com.lushwe.learn.tx.model.UserDO;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2021-06-26 14:49
 * @since 0.1
 */
public interface UserService {

    void updateForRequired(UserDO userDO);

    void updateForRequiredNew(UserDO userDO);

    void updateForNested(UserDO userDO);
}

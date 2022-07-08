package com.lushwe.learn.tx.service.impl;

import com.lushwe.learn.tx.dao.UserMapper;
import com.lushwe.learn.tx.model.UserDO;
import com.lushwe.learn.tx.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2021-06-26 14:50
 * @since 0.1
 */
@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public void updateForRequired(UserDO userDO) {
        userMapper.updateByPrimaryKeySelective(userDO);
//        System.out.println(1 / 0);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateForRequiredNew(UserDO userDO) {
        userMapper.updateByPrimaryKeySelective(userDO);
        System.out.println(1 / 0);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    @Override
    public void updateForNested(UserDO userDO) {
        userMapper.updateByPrimaryKeySelective(userDO);
        System.out.println(1 / 0);
    }
}

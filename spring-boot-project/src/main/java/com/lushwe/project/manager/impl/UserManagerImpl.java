package com.lushwe.project.manager.impl;

import com.lushwe.project.manager.UserManager;
import org.springframework.stereotype.Component;

/**
 * 说明：接口正常实现
 *
 * @author Jack Liu
 * @date 2020-08-26 13:34
 * @since 0.1
 */
@Component
public class UserManagerImpl implements UserManager {

    @Override
    public Object findUser(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return new Object();
    }
}

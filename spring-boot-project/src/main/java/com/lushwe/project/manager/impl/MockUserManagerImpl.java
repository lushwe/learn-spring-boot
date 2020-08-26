package com.lushwe.project.manager.impl;

import com.lushwe.project.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 说明：接口降级实现，带有降级逻辑
 *
 * @author Jack Liu
 * @date 2020-08-26 13:34
 * @since 0.1
 */
@Component("userManager")
public class MockUserManagerImpl implements UserManager {

    private static Object defaultObj = new Object();

    @Autowired
    private UserManager userManagerImpl;

    @Override
    public Object findUser(Object obj) {
        try {
            Object result = userManagerImpl.findUser(obj);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return createDefaultUser();
        }
    }

    private Object createDefaultUser() {
        return defaultObj;
    }
}

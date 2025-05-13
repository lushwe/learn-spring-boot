package com.lushwe.learn.tx.process;

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
 * @date 2021-06-26 15:02
 * @since 0.1
 */
@Component
public class UserProcess {

    @Resource
    private UserService userService;

    /**
     * REQUIRED + REQUIRED
     *
     * @param one
     * @param two
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void updateRequiredAndRequired(UserDO one, UserDO two) {
        // 1
        try {
            System.out.println("开始1");
            userService.updateForRequired(one);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2
        System.out.println("开始2");
        userService.updateForRequired(two);
//        System.out.println(1 / 0);
    }

    /**
     * REQUIRED + REQUIRED_NEW
     *
     * @param userDO
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void updateRequiredAndRequiredNew(UserDO userDO) {
        try {
            userService.updateForRequiredNew(userDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * REQUIRED + NESTED
     *
     * @param userDO1
     * @param userDO2
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void updateRequiredAndNested(UserDO userDO1, UserDO userDO2) {
        userService.updateForRequired(userDO1);
        try {
            userService.updateForNested(userDO1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

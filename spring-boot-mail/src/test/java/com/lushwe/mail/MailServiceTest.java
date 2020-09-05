package com.lushwe.mail;

import com.lushwe.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 说明：邮件服务测试
 *
 * @author Jack Liu
 * @date 2019/2/27 下午7:54
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Value("${mail.address.to}")
    private String to;

    @Test
    public void testSendSimpleMail() {

        String[] tos = to.split(",");
        mailService.sendSimpleMail(tos, "主题-测试", "内容-测试");
    }
}

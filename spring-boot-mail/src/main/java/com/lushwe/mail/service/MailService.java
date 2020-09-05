package com.lushwe.mail.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * 说明：邮件发送服务
 *
 * @author Jack Liu
 * @date 2019/2/27 下午7:28
 * @since 1.0
 */
@Slf4j
@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.address.from}")
    private String from;

    /**
     * @param to
     * @param subject
     * @param text
     */
    public void sendSimpleMail(String[] to, String subject, String text) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setTo(to);
        simpleMailMessage.setFrom(from);

        log.info("发送普通邮件，参数：{}", JSON.toJSONString(simpleMailMessage));
        javaMailSender.send(simpleMailMessage);
    }

}

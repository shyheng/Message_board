package com.shy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.shy.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
@Service(interfaceClass = MailService.class,version = "1.0.0",timeout = 15000)
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendEmail(Email email) {
//        创建一个MimeMessage
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        发送邮件的工具类
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {
            //设置邮件的基本内容
            mimeMessageHelper.setSubject(email.getTitle());
            mimeMessageHelper.setText(email.getContent(),true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(email.getTo());
            //发送邮件
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}

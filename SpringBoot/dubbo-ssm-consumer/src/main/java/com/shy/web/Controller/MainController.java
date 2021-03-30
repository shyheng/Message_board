package com.shy.web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shy.model.Email;
import com.shy.service.MailService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @Reference(interfaceClass = MailService.class,version = "1.0.0",check = false,timeout = 15000)
    private MailService mailService;

    @RequestMapping("/mail")
    public String  Main(String title,String content,Model model){
        Email email = new Email();
        email.setTo("2210278285@qq.com");
        email.setTitle(title);
        email.setContent(content);
        mailService.sendEmail(email);
        model.addAttribute("msg","发送成功");
        return "mail";
    }
}

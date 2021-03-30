package com.shy.web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shy.model.Users;
import com.shy.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Reference(interfaceClass = UsersService.class,version = "1.0.0",check = false,timeout = 15000)
    private UsersService usersService;

    @RequestMapping("/")
    public String longin(){
        return "login";
    }

    @RequestMapping("/toLogin")
    public String toLogin(String username, String password, Model model){
        Users users =  usersService.selectUsername(username);
        if(users == null){
            model.addAttribute("msg","无效账号");
            return "login";
        }
        if (users.getUsername().equals(username)){
            if (users.getPassword().equals(password)){
                return "index";
            }else {
                model.addAttribute("msg","密码错误");
                return "login";
            }
        }else {
            model.addAttribute("msg","无效账号");
            return "login";
        }
    }
}

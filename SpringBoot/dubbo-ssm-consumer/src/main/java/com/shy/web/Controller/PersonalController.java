package com.shy.web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shy.model.Personal;
import com.shy.model.Users;
import com.shy.service.PersonalService;
import com.shy.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalController {

    @Reference(interfaceClass = UsersService.class,version = "1.0.0",check = false,timeout = 15000)
    private UsersService usersService;

    @Reference(interfaceClass = PersonalService.class,version = "1.0.0",check = false,timeout = 15000)
    private PersonalService personalService;



    @RequestMapping("/user/personal")
    public String Personal(String phone, Model model){
        Personal personal =  personalService.selectPhone(phone);
        if (personal == null){
            model.addAttribute("msg","无效号码");
            return "phone";
        }
        model.addAttribute("personal",personal);
        return "personal";
    }

    @RequestMapping("/registered")
    public String registered(String username,String password,String passwordSalt,String sex,String birthday,Integer age,String phone){
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        users.setPasswordSalt(passwordSalt);
        usersService.insertUser(users);
        Personal personal = new Personal();
        personal.setSex(sex);
        personal.setBirthday(birthday);
        personal.setAge(age);
        personal.setPhone(phone);
        personalService.insertPersonal(personal);
        return "login";
    }
}

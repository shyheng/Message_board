package com.shy.web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shy.model.Users;
import com.shy.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChangeController {
    @Reference(interfaceClass = UsersService.class,version = "1.0.0",check = false,timeout = 15000)
    private UsersService usersService;

    @RequestMapping("/change")
    public String  change(String username, String password, String passwordSalt, Model model){
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        users.setPasswordSalt(passwordSalt);

        int i = usersService.upData(users);
        if (i == 0){
            model.addAttribute("msg","无效号码");
            return "change";
        }
        return "changes";
    }
}

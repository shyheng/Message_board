package com.shy.web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shy.service.PersonalService;
import com.shy.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

    @Reference(interfaceClass = UsersService.class,version = "1.0.0",check = false,timeout = 15000)
    private UsersService usersService;

    @Reference(interfaceClass = PersonalService.class,version = "1.0.0",check = false,timeout = 15000)
    private PersonalService personalService;

    @RequestMapping("/Logout")
    public String logout(String username, String phone, Model model){
        int i = usersService.deleteUser(username);
        int j = personalService.deletePersonal(phone);
        if (i == 0|| j == 0){
            model.addAttribute("msg","无效数字");
            return "cancellation";
        }
        return "Logout";
    }
}

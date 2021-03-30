package com.shy.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/")
    public String noLogin(){
        return "login";
    }

    @RequestMapping("/agreement")
    public String agreement(){
        return "agreement";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/mail")
    public String mail(){
        return "mail";
    }

    @RequestMapping("/regedit")
    public String regedit(){
        return "regedit";
    }

    @RequestMapping("/log")
    public String log(){
        return "log";
    }

    @RequestMapping("/api")
    public String api(){
        return "api";
    }

    @RequestMapping("/phone")
    public String phone(){
        return "phone";
    }

    @RequestMapping("/change")
    public String change(){
        return "change";
    }

    @RequestMapping("/cancellation")
    public String cancellation(){
        return "cancellation";
    }

    @RequestMapping("/wx")
    public String wx(){
        return "wx";
    }

    @RequestMapping("/zfb")
    public String zfb(){
        return "zfb";
    }

    @RequestMapping("/qr")
    public String QR(){
        return "qr";
    }

    @RequestMapping("/day")
    public String day(){
        return "day";
    }


}

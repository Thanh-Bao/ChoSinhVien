package com.chosinhvien.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("HomeControllerForWeb")
public class HomeController {

    @GetMapping("/trang-chu")
    public String home() {
        return "web/home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
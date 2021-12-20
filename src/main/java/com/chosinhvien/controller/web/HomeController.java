package com.chosinhvien.controller.web;

import com.chosinhvien.dto.UserDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller("HomeControllerForWeb")
public class HomeController {

    @GetMapping("/trang-chu")
    public String getHomePage() {
        return "web/home";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/test")
    public String getHomeTest() {
        return "web/test";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "login";
    }

}
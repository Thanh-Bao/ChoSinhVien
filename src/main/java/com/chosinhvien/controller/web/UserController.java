package com.chosinhvien.controller.web;

import com.chosinhvien.dto.UserDto;
import com.chosinhvien.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/signup")
    public String getSignupPage(@ModelAttribute("user") UserDto user, Model model) {
        System.out.println(user.toString());
        return "web/home";
    }

}

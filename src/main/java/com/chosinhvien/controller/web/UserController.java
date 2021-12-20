package com.chosinhvien.controller.web;

import com.chosinhvien.dto.UserDto;
import com.chosinhvien.entity.User;
import com.chosinhvien.service.IRegistrationService;
import com.chosinhvien.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final IRegistrationService registrationService;
    private final ModelMapper mapper;

    @PostMapping("/signup")
    public String register(@ModelAttribute("user") UserDto userDto, Model model) {
        User user = mapper.map(userDto, User.class);
        User newUser = registrationService.register(user);
        System.out.println(newUser.toString());
        return "web/home";
    }

    @GetMapping("/signup/confirm")
    public String confirm(@RequestParam("token") String token, Model model) {
        String confirmed = registrationService.confirmToken(token);
        model.addAttribute("confirmed", confirmed);
        return "web/test";
    }

}

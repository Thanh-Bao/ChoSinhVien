package com.chosinhvien.controller.admin;

import com.chosinhvien.dto.UserDto;
import com.chosinhvien.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller("HomeControllerForAdmin")
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/admin/home")
    public String home(Model model) {
        List<UserDto> listUser = userService.findAll();
        model.addAttribute("listUser",listUser);
        return "admin/home";
    }

}

package com.example.member_find_site.controller;

import com.example.member_find_site.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @PostMapping("/login")
    public String login(User user, Model model) {
        model.addAttribute("email", user.getEmail());

        System.out.println("userEmail ==>>"+model.getAttribute("email"));
        return "index";
    }
}

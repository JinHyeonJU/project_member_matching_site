package com.example.member_find_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String gotologin(){
        return "pages/Login";
    }
}

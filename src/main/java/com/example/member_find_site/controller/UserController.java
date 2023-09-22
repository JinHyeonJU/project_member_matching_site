package com.example.member_find_site.controller;

import com.example.member_find_site.Service.MemberService;
import com.example.member_find_site.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class UserController {
    //생성자 주입 @RequiredArgsConstructor어노테이션 필요
    private final MemberService memberService;

    @GetMapping("/login")
    public String login(){

        return "/pages/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        System.out.println("로그인 정보"+loginResult);
        if (loginResult != null) {
            //success
            System.out.println("login success");
            session.setAttribute("userLoginId", loginResult.getId());
            return "index";
        } else{
            //fail
            System.out.println("login fail");
            return "/pages/login";
        }
    }

    @GetMapping("/join")
    public String JoinForm() {

        return "/pages/join";
    }

    @PostMapping("/join")
    public String Join(@ModelAttribute MemberDTO memberDTO) {
        memberDTO.setRole("MEMBER");
        memberService.save(memberDTO);

        return "/pages/login";
    }
}

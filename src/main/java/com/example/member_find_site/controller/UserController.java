package com.example.member_find_site.controller;

import com.example.member_find_site.Service.MemberService;
import com.example.member_find_site.dto.MemberDTO;
import com.example.member_find_site.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    public String login(@ModelAttribute MemberDTO memberDTO,
                                HttpServletResponse res) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            //success
            SecurityService securityService = new SecurityService();
            Long LongId = loginResult.getId();
            int id = Long.valueOf(LongId).intValue();
            String token = securityService.getToken("id", id);

            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            res.addCookie(cookie);

            return "index";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
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

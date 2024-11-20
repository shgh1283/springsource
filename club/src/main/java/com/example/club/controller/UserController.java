package com.example.club.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/login")
    public void getMethodName() {
        log.info("로그인 폼 요청");
    }

    @GetMapping("/member")
    public void getMember() {
        log.info("member 페이지 요청");
    }

    @GetMapping("/admin")
    public void getAdmin() {
        log.info("admin 페이지 요청");
    }

    @ResponseBody
    @GetMapping("/auth")
    public Authentication getAuthentication() {

        // SecurityContext : 인증된 유저를 저장하는 곳
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return authentication;
    }

}

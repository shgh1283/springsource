package com.example.project1.controller;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project1.dto.LoginDto;
import com.example.project1.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@Controller
@RequestMapping("/member")

public class MemberController {

    @GetMapping("/login")
    public void getLogin() {
        log.info("login 페이지 요청");
    }

    // @PostMapping("/login")
    // public void postlogin(HttpServletRequest request) {
    // log.info("login 요청 - 사용자 입력값 요청");

    // String userid = request.getParameter("userid");
    // String password = request.getParameter("password");

    // log.info("userid : {}, password {}", userid, password);

    // }

    // @PostMapping("/login")
    // public void postlogin(String userid, String password) {
    // log.info("login 요청 - 사용자 입력값 요청");
    // log.info("userid : {}, password {}", userid, password);

    // }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("login") LoginDto loginDto) {
        log.info("login 요청 - 사용자 입력값 요청");
        log.info("userid : {}, password {}", loginDto.getUserid(), loginDto.getPassword());

        return "index";
    }

    @GetMapping("/register")
    public void getRegister() {
        log.info("register 요청");
    }

    // post / return => 로그인 페이지
    @PostMapping("/register")
    public String postRegister(MemberDto memberDto) {
        log.info("회원가입 요청 {}", memberDto);

        return "redirect:/member/login"; // redirect : 경로 ,http://localhost:8080/login
    }

    @PostMapping("/path")
    public void method1() {
        // 1) 입력값 가져오기
        // 2) service 호출 후 결과 받기
        // 3) model.addAttribute()
        // 4) 페이지 이동
    }

}

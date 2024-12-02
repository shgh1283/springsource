package com.example.movie.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.movie.dto.AuthMemberDto;
import com.example.movie.dto.MemberDto;
import com.example.movie.dto.PageRequestDto;
import com.example.movie.dto.PasswordDto;
import com.example.movie.service.MemberService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public void getMethodName(@ModelAttribute("requestDto") PageRequestDto pageRequestDto) {
        log.info("로그인 폼 요청");
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public void getProfile(@ModelAttribute("requestDto") PageRequestDto pageRequestDto) {
        log.info("프로필 폼 요청");
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/edit")
    public void getEdit(@ModelAttribute("requestDto") PageRequestDto pageRequestDto) {
        log.info("프로필 수정 폼 요청");
    }

    // 닉네임 수정

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/edit/nickname")
    public String postUpdateName(MemberDto memberDto) {
        log.info("닉네임 수정");
        // email 가져오기
        Authentication authentication = getAutentication();
        // MemberDto 에 들어있는 값 접근 시
        AuthMemberDto authMemberDto = (AuthMemberDto) authentication.getPrincipal();
        memberDto.setEmail((authMemberDto.getUsername()));

        memberService.nickNickUpdate(memberDto);

        // SecurityContext 에 보관된 값 업데이트
        authMemberDto.getMemberDto().setNickname(memberDto.getNickname());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/member/profile";
    }
    // 비밀번호 수정

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/edit/password")
    public String postUpdatePassword(PasswordDto passwordDto, HttpSession session, RedirectAttributes rttr) {
        log.info("비밀번호 수정");

        // 서비스 호출
        try {
            memberService.passwordUpdate(passwordDto);
        } catch (Exception e) {
            // 실패시 /edit
            e.printStackTrace();
            rttr.addFlashAttribute("error", e.getMessage());
            return "redirect:/member/edit";
        }
        // 성공 시 세션 해제 후 /login 이동
        session.invalidate();
        return "redirect:/member/login";
    }

    // 개발자용 - Authentication 확인용
    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    @GetMapping("/auth")
    public Authentication getAutentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return authentication;

    }

}
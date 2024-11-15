package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.board.dto.BoardDto;
import com.example.board.dto.PageRequestDto;
import com.example.board.dto.PageResultDto;

import com.example.board.service.BoardService;

import jakarta.validation.Valid;

@RequiredArgsConstructor
@Log4j2
@RequestMapping("/board")
@Controller
public class BoardController {

    private final BoardService boardservice;

    @GetMapping("/list")
    public void list(@ModelAttribute("requestDto") PageRequestDto requestDto, Model model) {
        PageResultDto<BoardDto, Object[]> result = boardservice.getList(requestDto);
        log.info("list 요청");
        model.addAttribute("result", result);
    }

    @GetMapping({ "/read", "/modify" })
    public void getRow(@RequestParam Long bno, @ModelAttribute("requestDto") PageRequestDto requestDto, Model model) {
        log.info("상세조회 {}", bno);
        BoardDto dto = boardservice.read(bno);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/modify")
    public String postModify(BoardDto dto, @ModelAttribute("requestDto") PageRequestDto requestDto,
            RedirectAttributes rttr) {
        // 수정 완료 후 상세조회로 이동
        Long bno = boardservice.update(dto);
        // 상세조회로 이동
        rttr.addAttribute("bno", bno);
        rttr.addAttribute("page", requestDto.getPage());
        rttr.addAttribute("size", requestDto.getSize());
        rttr.addAttribute("type", requestDto.getType());
        rttr.addAttribute("keyword", requestDto.getKeyword());

        return "redirect:read";
    }

    @PostMapping("/remove")
    public String postRemove(@RequestParam Long bno, @ModelAttribute("requestDto") PageRequestDto requestDto,
            RedirectAttributes rttr) {
        log.info("guestbook 삭제 요청 {}", bno);
        boardservice.remove(bno);

        // 전체 목록으로 이동
        rttr.addAttribute("page", requestDto.getPage());
        rttr.addAttribute("size", requestDto.getSize());
        rttr.addAttribute("type", requestDto.getType());
        rttr.addAttribute("keyword", requestDto.getKeyword());

        return "redirect:list";
    }

    @GetMapping("/register")
    public void getRegister(@ModelAttribute("dto") BoardDto dto) {
        log.info("guestbook 작성 폼 요청");
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("dto") BoardDto dto, BindingResult result,
            RedirectAttributes rttr) {
        log.info("guestbook 등록 요청 {}", dto);
        if (result.hasErrors()) {
            return "/board/register";
        }

        Long bno = boardservice.register(dto);

        rttr.addFlashAttribute("msg", bno);
        rttr.addAttribute("page", 1);
        rttr.addAttribute("size", 20);
        rttr.addAttribute("type", "");
        rttr.addAttribute("keyword", "");

        return "redirect:list";

    }
}

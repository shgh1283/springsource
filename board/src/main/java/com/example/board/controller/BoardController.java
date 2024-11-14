package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.board.service.BoardService;

@RequiredArgsConstructor
@Log4j2
@RequestMapping("/board")
@Controller
public class BoardController {

    private final BoardService boardservice;

    @GetMapping("/list")
    public void list() {

    }

}

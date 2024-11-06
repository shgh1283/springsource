package com.example.book.controller;

import org.springframework.stereotype.Controller;

import com.example.book.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
@Controller
public class BookController {
    private final BookService bookService;
}

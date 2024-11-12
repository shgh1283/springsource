package com.example.book.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// http://localhost:8080/book/list?page=2&size=20&type=c&keyword=소년

@ToString
@Builder
@AllArgsConstructor
@Setter
@Getter
public class PageRequestDto {
    private int page;
    private int size;

    public PageRequestDto() {
        this.page = 1;
        this.size = 10;

    }

    public Pageable getPageable(Sort sort) {
        // 0 : 1 page
        return PageRequest.of(-1, size, sort);
    }
}

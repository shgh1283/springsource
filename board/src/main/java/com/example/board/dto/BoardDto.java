package com.example.board.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class BoardDto {

    private Long bno;

    @NotBlank(message = "content 는 필수 입력 요소입니다.")
    private String content;
    @NotBlank(message = "title 은 필수 입력 요소입니다.")
    private String title;

    // private Member member;
    // private String email;
    // private String name;

    @NotBlank(message = "작성자는 필수 입력 요소입니다.")
    @Email(message = " 이메일 형식을 확인해 주세요")
    private String writerName;
    private String writerEmail;

    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    // 댓글 개수
    private Long replyCnt;
}

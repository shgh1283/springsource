package com.example.board.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Builder
@Getter
public class BoardDto {
    private Long bno;

    @NotBlank(message = "content 는 필수 입력 요소입니다.")
    private String content;
    @NotBlank(message = "title 은 필수 입력 요소입니다.")
    private String title;
    @NotBlank(message = "email 은 필수 입력 요소입니다.")
    private String writerEmail;

    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
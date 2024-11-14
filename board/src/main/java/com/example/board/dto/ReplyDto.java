package com.example.board.dto;

import java.time.LocalDateTime;

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
public class ReplyDto {
    private Long rno;

    private String replyer;

    private String text;

    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}

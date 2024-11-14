package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.entity.Board;

public interface BoardService {
    // dtoToEntity
    default Board dtoToEntity(BoardDto dto) {
        Board entity = Board.builder()
                .bno(dto.getBno())
                .content(dto.getContent())
                .title(dto.getTitle())
                .build();
        return entity;
    }

    // entityToDto
    default BoardDto entityToDto(Board entity) {
        BoardDto dto = BoardDto.builder()
                .bno(entity.getBno())
                .content(entity.getContent())
                .title(entity.getTitle())
                .regDate(entity.getRegDate())
                .updateDate(entity.getUpdateDate())
                .build();
        return dto;
    }
}

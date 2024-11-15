package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.dto.PageRequestDto;
import com.example.board.dto.PageResultDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;

public interface BoardService {

    // crud
    Long register(BoardDto dto);

    PageResultDto<BoardDto, Object[]> getList(PageRequestDto requestDto);

    BoardDto read(Long bno);

    Long update(BoardDto dto);

    void remove(Long bno);

    // dtoToEntity
    public default Board dtoToEntity(BoardDto dto) {
        Member member = Member
                .builder()
                .email(dto.getWriterEmail())
                .build();

        return Board.builder()
                .bno(dto.getBno())
                .content(dto.getContent())
                .title(dto.getTitle())
                .writer(member)
                .build();

    }

    // entityToDto
    public default BoardDto entityToDto(Board board, Member member, Long replyCnt) {
        return BoardDto.builder()
                .bno(board.getBno())
                .content(board.getContent())
                .title(board.getTitle())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .regDate(board.getRegDate())
                .updateDate(board.getUpdateDate())
                .replyCnt(replyCnt)
                .build();

    }
}

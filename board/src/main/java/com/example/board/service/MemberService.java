package com.example.board.service;

import com.example.board.dto.MemberDto;
import com.example.board.entity.Member;

public interface MemberService {
    // // dtoToEntity
    // default Member dtoToEntity(MemberDto dto) {
    // Member entity = Member.builder()
    // .email(dto.getEmail())
    // .name(dto.getName())
    // .password(dto.getPassword())
    // .build();
    // return entity;
    // }

    // // entityToDto
    // default MemberDto entityToDto(Member entity) {
    // MemberDto dto = MemberDto.builder()
    // .email(entity.getEmail())
    // .name(entity.getName())
    // .password(entity.getPassword())
    // .regDate(entity.getRegDate())
    // .updateDate(entity.getUpdateDate())
    // .build();
    // return dto;
    // }
}

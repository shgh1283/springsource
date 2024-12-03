package com.example.movie.service;

import com.example.movie.dto.MemberDto;
import com.example.movie.dto.PasswordDto;
import com.example.movie.entity.Member;
import com.example.movie.entity.constant.MemberRole;

public interface MemberService {

    // 닉네임 수정
    void nickNickUpdate(MemberDto memberDto);

    // 비밀번호 수정
    void passwordUpdate(PasswordDto passwordDto) throws Exception;

    // 회원탈퇴
    void leave(PasswordDto passwordDto) throws Exception;

    // 회원가입
    String register(MemberDto memberDto);

    // dtoToEntity
    default Member dtoToEntity(MemberDto memberDto) {
        return Member.builder()
                .mid(memberDto.getMid())
                .email(memberDto.getEmail())
                .nickname(memberDto.getNickname())
                .password(memberDto.getPassword())
                .role(MemberRole.MEMEBER)
                .build();
    }

    // default MemberDto dtoToEntity(Member member) {
    // return MemberDto.builder()
    // .mid(member.getMid())
    // .email(member.getEmail())
    // .nickname(member.getNickname())
    // .password(member.getPassword())
    // .role(MemberRole.MEMEBER)
    // .build();
    // }
}

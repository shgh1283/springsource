package com.example.club.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClubMemberDto {
    // email 형식인지 검증, 비어 있으면 안됨
    // password, name 비어있으면 안됨

    @NotBlank(message = "이메일은 필수 입력 요소입니다.")
    @Email(message = " 이메일 형식을 확인해 주세요")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력 요소입니다.")
    private String password;
    @NotBlank(message = "이름은 필수 입력 요소입니다.")
    private String name;
    private boolean fromSocial;
}

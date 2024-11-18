package com.example.project1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SampleDto2 {
    private Long mno;
    private String firstName;
    private String lastName;

}

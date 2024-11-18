package com.example.project1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.project1.dto.SampleDto2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 컨트롤러에 ㅇ노테이션 추가
// 1) @Controller : view(html, jsp ..) 를 찾으러감
// 2) @ResrController : 리턴 값이 브라우저에 보여짐
//      - 객체 리턴 가능 : 객체는 브라우저에 띄울 수 없음
//          ==> converter 가 필요함 (spring boot 가 자동으로 라이브러리를 가지고 있음)
//              객체 <==> json

@RestController
public class TestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/sample2")
    public List<SampleDto2> getSample2() {
        List<SampleDto2> list = new ArrayList<>();
        LongStream.rangeClosed(1, 10).forEach(i -> {
            SampleDto2 sampleDto2 = SampleDto2.builder()
                    .mno(i)
                    .firstName("hong")
                    .lastName("dong")
                    .build();

            list.add(sampleDto2);
        });
        return list;
    }

}

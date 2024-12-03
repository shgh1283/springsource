package com.example.movie.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import com.example.movie.entity.Member;
import com.example.movie.entity.constant.MemberRole;

import jakarta.transaction.Transactional;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 50).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@naver.com")
                    .password(passwordEncoder.encode("1111"))
                    .nickname("nickname" + i)
                    .role(MemberRole.MEMEBER)
                    .build();
            memberRepository.save(member);
        });
    }

    @Test
    public void testUpdate() {
        Member member = memberRepository.findById(2L).get();
        member.setNickname("Akaps");
        memberRepository.save(member);
    }

    @Test
    @Transactional
    public void testUpdate2() {

        memberRepository.updateNickname("Akaps", "user3@naver.com");

    }

    @Commit
    @Transactional
    @Test
    public void testDelete() {

        reviewRepository.deleteByMember(Member.builder().mid(48L).build());

        memberRepository.deleteById(48L);
    }

}

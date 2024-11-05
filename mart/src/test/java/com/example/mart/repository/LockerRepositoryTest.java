package com.example.mart.repository;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mart.entity.sports.SportsMember;
import com.example.mart.entity.sports.Locker;
import com.example.mart.repository.sports.LockerRepository;
import com.example.mart.repository.sports.SportsMemberRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class LockerRepositoryTest {
    @Autowired
    private SportsMemberRepository memberRepository;

    @Autowired
    private LockerRepository lockerRepository;

    @Test
    public void testLockerInsert() {
        // locker 4
        IntStream.rangeClosed(9, 10).forEach(i -> {
            Locker locker = Locker.builder().name("locker" + i).build();
            lockerRepository.save(locker);
        });
        // member 4
        LongStream.rangeClosed(9, 10).forEach(i -> {

            Locker locker = Locker.builder().id(i).build();

            SportsMember member = SportsMember.builder().name("user" + i).locker(locker).build();

            memberRepository.save(member);
        });
    }

    @Test
    public void testMemberUpdate() {
        SportsMember sportsMember = memberRepository.findById(6L).get();
        sportsMember.setName("test6");
        memberRepository.save(sportsMember);
    }

    @Transactional
    @Test
    public void testMemberRead() {
        // 회원 조회(+Locker 조회)
        SportsMember sportsMember = memberRepository.findById(3L).get();

        // 객체 그래프 탐색
        System.out.println(sportsMember.getLocker());

        // 전체회원 조회
        memberRepository.findAll().forEach(member -> {
            System.out.println(member);
            System.out.println(member.getLocker());
        });
    }

    @Test
    public void testLockerRead() {
        // 라컨 조회(+Locker 조회)
        lockerRepository.findAll().forEach(locker -> {
            System.out.println(locker);
            System.out.println(locker.getSportsMember());
        });
    }
}

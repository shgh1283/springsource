package com.example.memo.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.memo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest {

    @Autowired
    private MemoRepository memoRepository;

    @Test
    public void testMemoInsert() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Memo memo = Memo.builder().memoText("memo text" + i).build();
            memoRepository.save(memo);
        });

    }

    @Test
    public void testMemoRead() {
        // 6번 메모 가져오기
        Memo memo = memoRepository.findById(1L).get();
        System.out.println(memo);
        System.out.println();

        // 전체 메모 가져오기
        List<Memo> list = memoRepository.findAll();
        list.forEach(m -> System.out.println(m));

    }

    @Test
    public void testMemoUpdate() {
        // 7 번 메모 내용 수정
        Memo memo = memoRepository.findById(7L).get();
        memo.setMemoText("memo 수정");
        memoRepository.save(memo);
    }

    @Test
    public void testMemoDelete() {
        // 메모 삭제
        memoRepository.deleteById(30L);
    }

    // 쿼리 메소드 테스트
    @Test
    public void testQueryMethod() {
        // memoRepository.findByMnoLessThan(5L).forEach(m -> System.out.println(m));

        // memoRepository.findByMnoLessThanOrderByIdDesc(50L).forEach(m
        // ->System.out.println(m));
        memoRepository.findByMnoBetween(5L, 10L).forEach(m -> System.out.println(m));
    }
}

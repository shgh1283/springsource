package com.example.board.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.entity.Reply;

import jakarta.transaction.Transactional;

@SpringBootTest

public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsertMember() {
        // 30명
        IntStream.rangeClosed(1, 30).forEach(i -> {
            Member member = Member.builder()
                    .email("user" + i + "@gmail.com")
                    .name("1111")
                    .password("password" + i)
                    .build();
            memberRepository.save(member);
        });
    }

    @Test
    public void testInsertBoard() {
        // 100개
        IntStream.rangeClosed(1, 100).forEach(i -> {

            int num = (int) (Math.random() * 30) + 1;
            Member member = Member.builder().email("user" + num + "@gmail.com").build();

            Board board = Board.builder()
                    .content("Content" + i)
                    .title("title" + i)
                    .writer(member)
                    .build();
            boardRepository.save(board);
        });
    }

    @Test
    public void testInsertReply() {
        // 100개
        IntStream.rangeClosed(1, 100).forEach(i -> {

            long bno = (long) (Math.random() * 100) + 1;
            Board board = Board.builder().bno(bno).build();

            Reply reply = Reply.builder()
                    .board(board)
                    .replyer("Replyer" + i)
                    .text("text" + i)
                    .build();
            replyRepository.save(reply);
        });
    }

    @Transactional
    @Test
    public void testReadBoard() {
        // 100
        Board board = boardRepository.findById(100L).get();
        System.out.println(board);

        // 객체 그래프 탐색 : Board, Member 관계(N:1)
        System.out.println(board.getWriter());
    }

    @Transactional
    @Test
    public void testReadReply() {
        // 100
        Reply reply = replyRepository.findById(100L).get();
        System.out.println(reply);

        // 객체 그래프 탐색 : Reply, Board 관계(N:1)
        // 원본글 조회
        System.out.println(reply.getBoard());
    }

    @Transactional
    @Test
    public void testReadBoardReply() {
        // 100
        Board board = boardRepository.findById(100L).get();
        System.out.println(board);

        System.out.println(board.getReplies());
    }

    @Test
    public void testJoin() {
        // 100
        List<Object[]> result = boardRepository.list();

        for (Object[] objects : result) {
            // [Board(bno=1, content=Content1, title=title1), Member(email=user7@gmail.com,
            // name=1111, password=password7)]
            System.out.println(Arrays.toString(objects));
            // Board board = (Board) objects[0];
            // Member member = (Member) objects[1];
            // Long replyCnt = (Long)objects[2];
        }
    }

    @Test
    public void testJoinList() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        Page<Object[]> result = boardRepository.list("tc", "content", pageable);

        for (Object[] objects : result) {

            System.out.println(Arrays.toString(objects));

        }
    }

    @Test
    public void testJoinRow() {

        Object[] object = boardRepository.getBoardByBno(100L);
        // [Board(bno=100, content=Content100, title=title100),
        // Member(email=user24@gmail.com, name=1111, password=password24), null]

        System.out.println(Arrays.toString(object));
    }

    @Transactional
    @Test
    public void testReplyRemove() {
        replyRepository.dedeleteByBno(2L);
        boardRepository.deleteById(2L);
    }
}

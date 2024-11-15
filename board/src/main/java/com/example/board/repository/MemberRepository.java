package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.entity.Member;
import com.example.board.repository.search.SearchBoardRepository;

public interface MemberRepository extends JpaRepository<Member, String>, SearchBoardRepository {

}

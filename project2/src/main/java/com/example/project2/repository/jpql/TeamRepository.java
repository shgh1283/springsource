package com.example.project2.repository.jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.project2.entity.jpql.Team;

public interface TeamRepository extends JpaRepository<Team, Long>, QuerydslPredicateExecutor<Team> {

}

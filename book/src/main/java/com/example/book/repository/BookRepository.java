package com.example.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.entity.Book;
import com.example.book.entity.QBook;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface BookRepository extends JpaRepository<Book, Long> {
    default Predicate makePredicate(String type, String keyword) {

        BooleanBuilder builder = new BooleanBuilder();

        QBook qBook = QBook.book;

        builder.and(qBook.id.gt(0L));

        return builder;
    }
}

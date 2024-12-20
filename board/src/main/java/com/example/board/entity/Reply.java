package com.example.board.entity;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "board" })
@Setter
@Builder
@Getter
@Entity
@EnableJpaAuditing
public class Reply extends BaseEntity {
    @SequenceGenerator(name = "reply_seq_gen", sequenceName = "reply_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_seq_gen")
    @Id
    private Long rno;

    @Column(nullable = false)
    private String replyer;

    @Column(nullable = false)
    private String text;

    // fetch => EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

}

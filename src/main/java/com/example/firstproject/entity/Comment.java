package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity //클래스명, 필드 바탕으로 DB TABLE 생성
@Getter
@Setter
@ToString
@AllArgsConstructor //모든필드 생성자
@NoArgsConstructor //기본 생성자
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 자동 1씩 증가 지원
    private Long id;

    @ManyToOne //댓글과 게시글은 다:1
    @JoinColumn(name = "article_id") //외래키 생성, Article 기본키와 매핑
    private Article article;

    @Column //테이블 컬럼
    private String nickname;

    @Column //테이블 컬럼
    private String body;
}

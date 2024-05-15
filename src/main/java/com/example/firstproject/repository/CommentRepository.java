package com.example.firstproject.repository;

import com.example.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//페이징 처리까지 해야되는 경우 JpaRepository
//단순 CRUD만 사용하는 경우 CrudRepository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    //특정 게시글의 모든 댓글 조회
    //nativeQuery = true : 일반 SQL 사용
    //파라미터 앞 : 명시 필수
    @Query(value = "SELECT * FROM comment WHERE article_id = :articleId", nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);

    //특정 닉네임의 모든 댓글 조회
    List<Comment> findByNickname(String nickname);
}

package com.example.demo.repository;

import com.example.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    //특정 게시글의 모든 댓글 조회
    @Query(value="SELECT * FROM comment WHERE article_id =:articleId", nativeQuery = true) //Value 속성에 실행하려는 쿼리 작성
    List<Comment> findByArticleId(@Param("articleId")Long articleId);
    //특정 닉네임의 모든 댓글 조회
    List<Comment> findByNickname(String nickname);
}
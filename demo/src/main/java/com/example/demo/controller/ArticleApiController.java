package com.example.demo.controller;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {
    @Autowired
    private ArticleService articleService;
    //GET
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleService.index();
    }
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }

   //POST
    @PostMapping("api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created = articleService.create(dto);
        return (created != null)?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    //PATCH
    @PatchMapping("api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        Article updated = articleService.update(id, dto);
        return (updated != null)?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
   //DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        //1. 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        //2. 잘못된 요청 처리
        if(target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //3. 대상 삭제하기
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest
            (@RequestBody List<ArticleForm> dtos){
        List<Article> articleList = articleService.createArticles(dtos);
        return (articleList != null)?
                ResponseEntity.status(HttpStatus.OK).body(articleList):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

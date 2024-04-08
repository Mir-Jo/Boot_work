package com.example.demo.service;

import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository; //게시글 리파지터리 객체 주입
    public List<Article> index() {
        return articleRepository.findAll();
    }
    public Article show(@PathVariable Long id){
        return articleRepository.findById(id).orElse(null);
    }
    public Article create(@RequestBody ArticleForm dto) {
        Article article = dto.toEntity();
        if(article.getId() != null){
            return null;
        }
        return articleRepository.save(article);
    }
    public Article update(Long id, ArticleForm dto){
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());
        Article target = articleRepository.findById(id).orElse(null);
        if(target == null || id != article.getId()){
            return null;
        }
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }
    public Article delete(@PathVariable Long id){
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null) {
            return null;
        }
        articleRepository.delete(target);
        return target;
    }
    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        //1 dto -> entity
        /*List<Article> articleList = new ArrayList<>();
        for(int i=0; i<dtos.size(); i++){
            ArticleForm dto = dtos.get(i);
            Article entity = dto.toEntity();
            articleList.add(entity);
        }*/
        List<Article> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());
        //2. DB저장
        for (int i=0; i<articleList.size(); i++) {
            Article article = articleList.get(i);
            articleList.stream().forEach(article1 -> articleRepository.save(article));
        }
        //3. 에러발생
        articleRepository.findById(-1L).orElseThrow(()->new IllegalArgumentException("결제 실패!"));
        //4. 결과값 반환
        return articleList;
    }
}

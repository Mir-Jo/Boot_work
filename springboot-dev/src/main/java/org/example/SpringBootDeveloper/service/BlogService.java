package org.example.SpringBootDeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.SpringBootDeveloper.domain.Article;
import org.example.SpringBootDeveloper.dto.AddArticleRequest;
import org.example.SpringBootDeveloper.dto.UpdateArticleRequest;
import org.example.SpringBootDeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
    public List<Article> findAll() {
        return blogRepository.findAll();
    }
    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));
    }
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
    @Transactional //트랜잭션 메서드
    public Article update(Long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}

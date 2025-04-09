package com.estsoft.spring_project.abc.blog.service;

import com.estsoft.spring_project.abc.blog.Article;
import com.estsoft.spring_project.abc.blog.dto.AddArticleRequest;
import com.estsoft.spring_project.abc.blog.dto.UpdateArticleRequest;
import com.estsoft.spring_project.abc.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Article saveArticle(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    // 전체 목록 조회 코드
    public List<Article> findArticles() {
        return blogRepository.findAll();
    }

    //블로그 게시글 단건 조회
    public Article findArticleById(Long id){
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not exists id: " + id));
    }

    public void deleteArticleById(Long id){
        blogRepository.deleteById(id);
    }

    public void deleteArticleAll(){
        blogRepository.deleteAll();
    }

    @Transactional
    public Article updateArticle(Long id, UpdateArticleRequest request){
        // findById
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not exists id: " + id));

        // update
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}

package com.estsoft.spring_project.abc.blog.controller;


import com.estsoft.spring_project.abc.blog.Article;
import com.estsoft.spring_project.abc.blog.dto.AddArticleRequest;
import com.estsoft.spring_project.abc.blog.dto.ArticleResponse;
import com.estsoft.spring_project.abc.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // ResponseEntity
    @PostMapping("/api/articles")
    public ResponseEntity<ArticleResponse> saveArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.saveArticle(request);

        // Article -> ArticleResponse 변환 후 리턴
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(savedArticle.toDto());
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<Article> articles = blogService.findArticles();

        List<ArticleResponse> responseBody = articles.stream().map(article -> new ArticleResponse(article.getId(), article.getTitle(), article.getContent()))
                .toList();
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/api/articles/{id}")
    public Article findArticleById(@PathVariable("id") Long id){
        return blogService.findArticleById(id);
    }
}

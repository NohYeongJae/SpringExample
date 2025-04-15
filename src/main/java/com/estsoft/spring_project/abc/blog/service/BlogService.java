package com.estsoft.spring_project.abc.blog.service;

import com.estsoft.spring_project.abc.blog.domain.Article;
import com.estsoft.spring_project.abc.blog.dto.AddArticleRequest;
import com.estsoft.spring_project.abc.blog.dto.ArticleResponse;
import com.estsoft.spring_project.abc.blog.dto.PostArticle;
import com.estsoft.spring_project.abc.blog.dto.UpdateArticleRequest;
import com.estsoft.spring_project.abc.blog.repository.BlogRepository;
import com.estsoft.spring_project.abc.comment.dto.CommentResponse;
import com.estsoft.spring_project.abc.comment.service.CommentService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final CommentService commentService;

    public BlogService(BlogRepository blogRepository, CommentService commentService) {
        this.blogRepository = blogRepository;
        this.commentService = commentService;
    }

    public Article saveArticle(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 전체 목록 조회 코드
    public List<Article> findArticles() {
        return blogRepository.findAll();
    }

    //블로그 게시글 단건 조회
    public Article findArticleById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not exists id: " + id));
    }

    public void deleteArticle(Long id) {
        blogRepository.deleteById(id);
    }

    public void deleteArticleAll() {
        blogRepository.deleteAll();
    }

    @Transactional
    public Article updateArticle(Long id, UpdateArticleRequest request) {
        // findById
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not exists id: " + id));

        // update
        article.update(request.getTitle(), request.getContent());
        return article;
    }

    public void updateArticleByApi() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PostArticle>> response = restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<PostArticle>>() {
                });

        List<PostArticle> postArticles = response.getBody();

        if (postArticles != null) {
            for (PostArticle post : postArticles) {
                Article article = Article.builder()
                        .title(post.getTitle())
                        .content(post.getBody())
                        .build();
                blogRepository.save(article);
            }
        }
    }
}

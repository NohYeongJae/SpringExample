package com.estsoft.spring_project.abc.blog.service;

import com.estsoft.spring_project.abc.blog.Article;
import com.estsoft.spring_project.abc.blog.dto.AddArticleRequest;
import com.estsoft.spring_project.abc.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

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
        Optional<Article>optArticle = blogRepository.findById(id);
        return optArticle.orElseGet(Article::new);
    }
}

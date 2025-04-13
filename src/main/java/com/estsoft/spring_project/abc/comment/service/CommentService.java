package com.estsoft.spring_project.abc.comment.service;


import com.estsoft.spring_project.abc.blog.domain.Article;
import com.estsoft.spring_project.abc.blog.repository.BlogRepository;
import com.estsoft.spring_project.abc.comment.dto.CommentRequest;
import com.estsoft.spring_project.abc.comment.dto.CommentResponse;
import com.estsoft.spring_project.abc.comment.dto.PostComment;
import com.estsoft.spring_project.abc.comment.domain.Comment;
import com.estsoft.spring_project.abc.comment.repository.CommentRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    public CommentService(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

    public void saveComment() {

        //외부 API 가져오기
        String url = "https://jsonplaceholder.typicode.com/comments";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PostComment>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<PostComment>>() {});

        List<PostComment> comments = response.getBody();

        for(PostComment postComment : comments){
            Article article = blogRepository.findById(postComment.getPostId()).orElse(null);

            if(article != null){
                Comment comment = Comment.builder()
                        .body(postComment.getBody())
                        .article(article)
                        .build();
                commentRepository.save(comment);
            }
        }
    }
    //댓글 정보 생성
    public CommentResponse createComment(Long articleId, CommentRequest request) {
        Article article = blogRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("Article Not Found"+ articleId));

        Comment comment = commentRepository.save(Comment.builder()
                .body(request.getBody())
                .article(article)
                .build()
        );
        return comment.toDTO();
    }

    //댓글 단건 조회
    public CommentResponse getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not exists id: " + id));
        return comment.toDTO();
    }

    //댓글 정보 수정
    public CommentResponse updateComment(Long commentId, String body) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found: " + commentId));
        
        comment.update(body);
        return comment.toDTO();
    }

    // 댓글 삭제
    public CommentResponse deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found: " + commentId));

        commentRepository.delete(comment);
        return comment.toDTO();
    }

    public List<CommentResponse> getCommentsByArticleId(Long articleId) {
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        return comments.stream()
                .map(Comment::toDTOWithoutArticle) // 또는 toDTO()
                .toList();
    }

}

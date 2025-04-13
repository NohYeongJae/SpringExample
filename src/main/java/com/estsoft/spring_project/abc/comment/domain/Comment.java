package com.estsoft.spring_project.abc.comment.domain;



import com.estsoft.spring_project.abc.blog.domain.Article;
import com.estsoft.spring_project.abc.comment.dto.CommentResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id",updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String body;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;


    @Builder
    public Comment(String body, Article article) {
        this.body = body;
        this.article = article;
    }
    public CommentResponse toDTO() {
        return new CommentResponse(id, article.getId(), body, createdAt, article.toDto());
    }

    public CommentResponse toDTOWithoutArticle() {
        return new CommentResponse(id, article.getId(), body, createdAt, null);
    }

    public void update(String body) {
        this.body = body;
    }





}

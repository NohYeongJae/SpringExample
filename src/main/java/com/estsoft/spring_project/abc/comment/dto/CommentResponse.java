package com.estsoft.spring_project.abc.comment.dto;


import com.estsoft.spring_project.abc.blog.dto.ArticleResponse;
import com.estsoft.spring_project.abc.comment.domain.Comment;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentResponse {

        private Long commentId;
        private Long articleId;
        private String body;
        private LocalDateTime createdAt;
        private ArticleResponse article;


}

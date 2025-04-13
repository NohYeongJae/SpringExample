package com.estsoft.spring_project.abc.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostArticle {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}

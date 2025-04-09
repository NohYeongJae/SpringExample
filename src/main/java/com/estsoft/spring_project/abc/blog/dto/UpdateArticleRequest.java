package com.estsoft.spring_project.abc.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticleRequest {
    private String title;
    private String content;
}

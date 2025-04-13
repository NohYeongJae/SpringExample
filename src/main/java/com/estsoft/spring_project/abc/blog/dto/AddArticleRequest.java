package com.estsoft.spring_project.abc.blog.dto;


import com.estsoft.spring_project.abc.blog.domain.Article;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRequest {
    private String title;

    @JsonProperty("body")
    private String content;

    public Article toDTO(){
        return new Article(title, content);
    }
}

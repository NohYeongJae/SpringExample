package com.estsoft.spring_project.abc.comment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostComment {
    private Long id;
    private Long postId;
    private String name;
    private String email;
    private String body;
}

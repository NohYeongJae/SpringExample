package com.estsoft.spring_project.abc.blog.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String email;
    private String password;
}

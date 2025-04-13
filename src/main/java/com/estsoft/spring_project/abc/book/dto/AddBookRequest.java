package com.estsoft.spring_project.abc.book.dto;


import com.estsoft.spring_project.abc.book.domain.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookRequest {
    private String id;
    private String name;
    private String author;

    public Book toEntity() {
        return new Book(id, name, author);
    }
}

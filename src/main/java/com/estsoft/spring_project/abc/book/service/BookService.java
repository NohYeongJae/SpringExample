package com.estsoft.spring_project.abc.book.service;


import com.estsoft.spring_project.abc.book.domain.Book;
import com.estsoft.spring_project.abc.book.dto.AddBookRequest;
import com.estsoft.spring_project.abc.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 책 목록 전체 조회
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    // 책 정보 저장
    public Book saveBook(AddBookRequest request) {
        Book book = request.toEntity();
        return bookRepository.save(book);
    }

    // 책 정보 단건 조회
    public Book getBook(String id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("no exists id "+ id));
    }
}

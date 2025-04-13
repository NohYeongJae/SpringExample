package com.estsoft.spring_project.abc.book.controller;


import com.estsoft.spring_project.abc.book.domain.Book;
import com.estsoft.spring_project.abc.book.dto.AddBookRequest;
import com.estsoft.spring_project.abc.book.dto.BookViewResponse;
import com.estsoft.spring_project.abc.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 전체 조회
    @GetMapping("/books")
    public String showBooks(Model model) {

        List<BookViewResponse> bookList = bookService.getBookList()
                .stream()
                .map(book -> new BookViewResponse(book))
                .toList();

        // List<Book> -> List<BookViewResponse>
        model.addAttribute("bookList", bookList);
        return "bookManage";
    }

    // 책 정보 단건 조회
    @RequestMapping(method = RequestMethod.GET, value = "/books/{id}")
    public String showBookDetail(@PathVariable("id") String id, Model model) {

        Book book = bookService.getBook(id);

        // Book -> BookViewResponse
        model.addAttribute("book", new BookViewResponse(book));
        return "bookDetail";
    }

    // Post /books 단건 저장
    // (form으로 저장할 데이터 전달)
    // -> GET /book로 리디렉션
    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public String addBook(@ModelAttribute AddBookRequest request) {
        bookService.saveBook(request);
        return "redirect:/books";
    }
}

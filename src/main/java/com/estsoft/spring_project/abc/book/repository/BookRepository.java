package com.estsoft.spring_project.abc.book.repository;


import com.estsoft.spring_project.abc.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}

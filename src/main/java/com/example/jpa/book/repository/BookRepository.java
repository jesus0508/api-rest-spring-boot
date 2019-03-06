package com.example.jpa.book.repository;

import com.example.jpa.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book findBookByTitle(String title);
}

package com.example.jpa.book.repository;

import com.example.jpa.book.domain.Author;
import com.example.jpa.book.domain.Book;
import com.example.jpa.book.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book findBookByTitle(String title);
    Set<Book> findByThemesName(String name);
    Set<Book> findByAuthors(Author author);
}

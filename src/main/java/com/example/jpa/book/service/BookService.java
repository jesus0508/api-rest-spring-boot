package com.example.jpa.book.service;

import com.example.jpa.book.domain.Author;
import com.example.jpa.book.domain.Book;

import java.util.Set;

public interface BookService {
    Set<Book> getAllBooks();
    Set<Book> getAllBooksByTheme(String themeName);
    Set<Book> getAllBooksByAuthor(Author author);
    Book getBook(Long id);
    Book saveBook(Book book);
    Book getBookByTitle(String title);
    Book updateBook(Book book,Long id);
    void deleteBook(Book book);
}

package com.example.jpa.book.service;

import com.example.jpa.book.domain.Book;

import java.util.Set;

public interface BookService {
    Set<Book> getAllBooks();
    Set<Book> getAllBooksByTheme();
    Set<Book> getAllBooksByAuthor();
    Book saveBook(Book book);
    Book getBookByTitle(String title);
    Book updateBook(Book book,Long id);
    void deleteBook(Book book);
}

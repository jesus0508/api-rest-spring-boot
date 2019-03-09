package com.example.jpa.book.service;

import com.example.jpa.book.domain.Author;
import com.example.jpa.book.domain.Book;

import java.util.Set;

public interface AuthorService {
    Set<Author> getAllAuthors();
    Author saveAuthor(Author author);
    Author getAuthor(Long id);
    Author getAuthorByName(String name);
    Set<Book> getAllBooks(String name);
}

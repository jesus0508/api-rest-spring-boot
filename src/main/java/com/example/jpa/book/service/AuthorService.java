package com.example.jpa.book.service;

import com.example.jpa.book.domain.Author;

import java.util.Set;

public interface AuthorService {
    Set<Author> getAllAuthors();
    Author saveAuthor(Author author);
    Author getAuthor(Long id);
    Author getAuthorByName(String name);
}

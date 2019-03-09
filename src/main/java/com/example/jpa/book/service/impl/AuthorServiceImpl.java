package com.example.jpa.book.service.impl;

import com.example.jpa.book.domain.Author;
import com.example.jpa.book.domain.Book;
import com.example.jpa.book.repository.AuthorRepository;
import com.example.jpa.book.service.AuthorService;
import com.example.jpa.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookService bookService;

    @Override
    public Set<Author> getAllAuthors() {
        Set<Author> authorSet=new HashSet<>();
        authorRepository.findAll().forEach(author -> authorSet.add(author));
        return authorSet;
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    public Author getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public Set<Book> getAllBooks(String name) {
        Author author=getAuthorByName(name);
        System.out.println(author.getSurname());
        return bookService.getAllBooksByAuthor(author);
    }
}

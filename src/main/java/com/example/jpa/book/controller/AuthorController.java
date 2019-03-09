package com.example.jpa.book.controller;

import com.example.jpa.book.domain.Author;
import com.example.jpa.book.domain.Book;
import com.example.jpa.book.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorService;

    @GetMapping
    public ResponseEntity<Set<Author>> getAllAuthor(){
        Set<Author> authorSet=authorService.getAllAuthors();
        return new ResponseEntity<>(authorSet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        return new ResponseEntity<> (authorService.saveAuthor(author),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id){
        Author author=authorService.getAuthor(id);
        return new ResponseEntity<>(author,HttpStatus.OK);
    }

    @GetMapping("/{name}/books")
    public ResponseEntity<Set<Book>> getAllBooksByAuthor(@PathVariable String name){
        Set<Book> bookSet=authorService.getAllBooks(name);
        return new ResponseEntity<>(bookSet,HttpStatus.OK);
    }
}

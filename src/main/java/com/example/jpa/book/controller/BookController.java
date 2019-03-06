package com.example.jpa.book.controller;

import com.example.jpa.book.domain.Book;
import com.example.jpa.book.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping
    public ResponseEntity<Set<Book>> getAll(){
        Set<Book>bookSet=bookService.getAllBooks();
        return new ResponseEntity<>(bookSet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        Book newBook=bookService.saveBook(book);
        return new ResponseEntity<>(newBook,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable Long id){
        Book updateBook=bookService.updateBook(book,id);
        return new ResponseEntity<>(updateBook,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
}

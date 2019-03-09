package com.example.jpa.book.service.impl;

import com.example.jpa.book.domain.Author;
import com.example.jpa.book.domain.Book;
import com.example.jpa.book.repository.BookRepository;
import com.example.jpa.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Set<Book> getAllBooks() {
        Set<Book> bookSet=new HashSet<>();
        bookRepository.findAll().forEach(book -> bookSet.add(book));
        return bookSet;
    }
    /**
     * IMPORTANTE REVISARRRR!!!!!
     * Metodo que buscar por el tema de nombre 1ra forma
     * *
     * */
    @Override
    public Set<Book> getAllBooksByTheme(String themeName) {
        Set<Book> bookSet=new HashSet<>();
        bookRepository.findByThemesName(themeName).forEach(book -> bookSet.add(book));
        return bookSet;
    }
    /**
     * IMPORTANTE REVISARRRR!!!!!
     * Metodo que buscar por clase Author
     * *
     * */
    @Override
    public Set<Book> getAllBooksByAuthor(Author author) {
        Set<Book> bookSet=new HashSet<>();
        bookRepository.findByAuthors(author).forEach(book -> bookSet.add(book));
        return bookSet;
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    @Override
    public Book updateBook(Book book, Long id) {
        Book updateBook=bookRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return bookRepository.save(updateBook);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }
}

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

    /*@GetMapping
    public ResponseEntity<Set<Book>> getAll(){
        Set<Book>bookSet=bookService.getAllBooks();
        return new ResponseEntity<>(bookSet, HttpStatus.OK);
    }*/

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book=bookService.getBook(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
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

    /*@GetMapping("/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title){
        Book book=bookService.getBookByTitle(title);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
*/
    /**
     *  PREGUNTAR!!!!!!!!!!!
     * Metodo que recibe una query por la url para filtrar libros por nombre de tema
     * GET /books?theme=comedia
     * */

    @GetMapping
    public ResponseEntity<Set<Book>> getAll(@RequestParam(required = false) String theme){
        Set<Book>bookSet;
        if(theme!=null){
            bookSet=bookService.getAllBooksByTheme(theme);
        }else{
            bookSet=bookService.getAllBooks();
        }

        return new ResponseEntity<>(bookSet, HttpStatus.OK);
    }
}

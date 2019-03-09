package com.example.jpa.book.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String isbn;
    @Column(nullable = false,unique = true)
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="authors_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="books_themes",
                joinColumns = @JoinColumn(name = "book_id"),
                inverseJoinColumns = @JoinColumn(name = "theme_id"))
    private Set<Theme> themes;

    public Book() { }

    public Book(String isbn, String title, Set<Author> authors, Set<Theme> themes) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.themes = themes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }

}

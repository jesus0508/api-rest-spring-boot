package com.example.jpa.book.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String isbn;
    @Column(nullable = false,unique = true)
    private String title;
    @ManyToMany
    private Set<Author> authorSet;
    @ManyToMany
    private Set<Theme> themeSet;

    public Book() {
    }

    public Book(String isbn, String title, Set<Author> authorSet, Set<Theme> themeSet) {
        this.isbn = isbn;
        this.title = title;
        this.authorSet = authorSet;
        this.themeSet = themeSet;
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

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public Set<Theme> getThemeSet() {
        return themeSet;
    }

    public void setThemeSet(Set<Theme> themeSet) {
        this.themeSet = themeSet;
    }
}

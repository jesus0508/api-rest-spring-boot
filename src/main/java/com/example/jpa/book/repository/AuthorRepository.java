package com.example.jpa.book.repository;

import com.example.jpa.book.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
    Author findByName(String name);
}

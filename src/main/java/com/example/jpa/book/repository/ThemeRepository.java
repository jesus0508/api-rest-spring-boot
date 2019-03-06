package com.example.jpa.book.repository;

import com.example.jpa.book.domain.Theme;
import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme, Long> {
}

package com.example.jpa.book.service;

import com.example.jpa.book.domain.Theme;

import java.util.Set;

public interface ThemeService {
    Set<Theme> getAllThemes();
    Theme getThemeById(Long id);
    Theme saveTheme(Theme theme);
}

package com.example.jpa.book.service.impl;

import com.example.jpa.book.domain.Theme;
import com.example.jpa.book.repository.ThemeRepository;
import com.example.jpa.book.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeRepository themeRepository;

    @Override
    public Set<Theme> getAllThemes() {
        Set<Theme>themeSet=new HashSet<>();
        themeRepository.findAll().forEach(theme -> themeSet.add(theme));
        return themeSet;
    }

    @Override
    public Theme getThemeById(Long id) {
        return themeRepository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public Theme saveTheme(Theme theme) {
        return themeRepository.save(theme);
    }
}

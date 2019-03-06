package com.example.jpa.book.controller;

import com.example.jpa.book.domain.Theme;
import com.example.jpa.book.service.impl.ThemeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/themes")
public class ThemeController {
    @Autowired
    ThemeServiceImpl themeServiceImpl;

    @GetMapping
    public ResponseEntity<Set<Theme>> getAllThemes(){
        Set<Theme> themeSet=themeServiceImpl.getAllThemes();
        return new ResponseEntity<>(themeSet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Theme> saveTheme(@RequestBody Theme theme){
        Theme newTheme=themeServiceImpl.saveTheme(theme);
        return new ResponseEntity<>(newTheme, HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Theme> getThemeByName(@PathVariable Long id){
        Theme theme=themeServiceImpl.getThemeById(id);
        return new ResponseEntity<>(theme,HttpStatus.OK);
    }
}

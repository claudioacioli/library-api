package com.bootcamp.library.api.controller;

import com.bootcamp.library.api.model.Author;
import com.bootcamp.library.api.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RestController
@RequestMapping("/api/v1.0/authors")
public class AuthorController {
    private static final AuthorService authorService = AuthorService.getInstance();

    @GetMapping
    public Collection<Author> readAll () {
        return authorService.getAll();
    }

    @PostMapping
    public void create (@RequestBody Author author) {
        authorService.addAuthor(
            author.getName(),
            author.getEmail(),
            author.getResume(),
            author.getBirthday()
        );
    }
}
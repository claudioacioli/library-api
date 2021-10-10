package com.bootcamp.library.api.controller;

import com.bootcamp.library.api.dto.FormAuthorDTO;
import com.bootcamp.library.api.dto.SimpleAuthorDTO;
import com.bootcamp.library.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Collection;

/** This controller provides endpoints handle with Author entity
 *
 * @author claudio
 * @see AuthorService
 * create on 2021/09/26
 */
@Controller
@RestController
@RequestMapping("/api/v1.0/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Collection<SimpleAuthorDTO> readAll () {
        return authorService.getAll();
    }

    @GetMapping("{email}")
    public FormAuthorDTO read (@PathVariable @Valid @Email String email) {
        return authorService.getAuthor(email);
    }

    @PostMapping
    public void create (@RequestBody @Valid FormAuthorDTO author) {
        authorService.addAuthor(author);
    }

    @PutMapping
    public void update (@RequestBody @Valid FormAuthorDTO author) {
        authorService.updateAuthor(author);
    }

    @DeleteMapping("{email}")
    public void delete (@PathVariable String email) {
        authorService.removeAuthor(email);
    }
}

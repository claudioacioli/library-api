package com.bootcamp.library.api.controller;

import com.bootcamp.library.api.dto.FormAuthorDTO;
import com.bootcamp.library.api.dto.SimpleAuthorDTO;
import com.bootcamp.library.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.net.URI;
import java.util.Collection;

/** This controller provides endpoints handle with Author entity
 *
 * @author claudio
 * @see AuthorService
 * create on 2021/09/26
 */
@Controller
@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Page<SimpleAuthorDTO> readAll (Pageable pageable) {
        return authorService.getAll(pageable);
    }

    @GetMapping("/{email}")
    public FormAuthorDTO read (@PathVariable @Valid @Email String email) {
        return authorService.getAuthor(email);
    }

    @PostMapping
    public ResponseEntity<FormAuthorDTO> create (@RequestBody @Valid FormAuthorDTO author, UriComponentsBuilder uriBuilder) {
        authorService.addAuthor(author);
        URI uri = uriBuilder.path("/authors/{email}").buildAndExpand(author.getEmail()).toUri();
        return ResponseEntity.created(uri).body(author);
    }

    @PutMapping
    public void update (@RequestBody @Valid FormAuthorDTO author) {
        authorService.updateAuthor(author);
    }

    @DeleteMapping("/{email}")
    public void delete (@PathVariable String email) {
        authorService.removeAuthor(email);
    }
}

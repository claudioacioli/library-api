package com.bootcamp.library.api.controller;

import com.bootcamp.library.api.dto.FormAuthorDTO;
import com.bootcamp.library.api.dto.SimpleAuthorDTO;
import com.bootcamp.library.api.resource.AuthorResource;
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
 * @see AuthorResource
 * create on 2021/09/26
 */
@Controller
@RestController
@RequestMapping("/api/v1.0/authors")
public class AuthorController {

    private AuthorService authorService = AuthorService.getInstance();
    private static final AuthorResource authorResource = AuthorResource.getInstance();

    @GetMapping
    public Collection<SimpleAuthorDTO> readAll () {
        return authorService.getAll();
    }

    @GetMapping("{email}")
    public FormAuthorDTO read (@PathVariable @Valid @Email String email) {
        return authorResource.getAuthor(email);
    }

    @PostMapping
    public void create (@RequestBody @Valid FormAuthorDTO author) {
        authorResource.addAuthor(author);
    }

    @PutMapping
    public void update (@RequestBody @Valid FormAuthorDTO author) {
        authorResource.updateAuthor(author);
    }

    @DeleteMapping("{email}")
    public void delete (@PathVariable String email) {
        authorResource.removeAuthor(email);
    }
}

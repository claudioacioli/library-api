package com.bootcamp.library.api.controller;

import com.bootcamp.library.api.dto.FormAuthorDTO;
import com.bootcamp.library.api.dto.SimpleAuthorDTO;
import com.bootcamp.library.api.resource.AuthorResource;
import com.bootcamp.library.api.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    private static final AuthorResource authorResource = AuthorResource.getInstance();

    @GetMapping
    public Collection<SimpleAuthorDTO> readAll () {
        return authorResource.getAll();
    }

    @PostMapping
    public void create (@RequestBody FormAuthorDTO author) {
        authorResource.addAuthor(author);
    }
}

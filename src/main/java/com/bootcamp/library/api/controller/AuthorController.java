package com.bootcamp.library.api.controller;

import com.bootcamp.library.api.dto.SimpleAuthorDTO;
import com.bootcamp.library.api.service.AuthorService;
import com.bootcamp.library.api.resource.SimpleAuthorResource;
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
    private static final SimpleAuthorResource simpleAuthorResource = SimpleAuthorResource.getInstance();

    @GetMapping
    public Collection<SimpleAuthorDTO> readAll () {
        return simpleAuthorResource.getAll();
    }

    @PostMapping
    public void create (@RequestBody SimpleAuthorDTO author) {
        simpleAuthorResource.addAuthor(author);
    }
}

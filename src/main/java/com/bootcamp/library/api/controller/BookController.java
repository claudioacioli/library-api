package com.bootcamp.library.api.controller;

import com.bootcamp.library.api.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** This controller provides endpoints to handle Books
 *
 * @author claudio
 * create on 2021/09/26
 * @see BookService
 */

@Controller
@RestController
@RequestMapping("/api/v1.0/books")
public class BookController {

    private static final BookService boookService = BookService.getInstance();

}

package com.bootcamp.library.api.controller;

import com.bootcamp.library.api.dto.ItemAuthorBooksDTO;
import com.bootcamp.library.api.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Controller
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/authors")
    public Collection<ItemAuthorBooksDTO> getResumeAuthorXBoos() {
        return resumeService.getAuthorXBooks();
    }
}

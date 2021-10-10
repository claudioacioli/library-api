package com.bootcamp.library.api.component;

import com.bootcamp.library.api.dto.FormAuthorDTO;
import com.bootcamp.library.api.dto.FormBookDTO;
import com.bootcamp.library.api.service.AuthorService;
import com.bootcamp.library.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataLoader {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

   @PostConstruct
    private void loadData() {
        createAuthors();
        createBooks();
    }

    private void createAuthors () {

        String[] names = new String[] {
                "Kate Sierra",
                "Robert C. Martin",
                "Hebert Schildt"
        };

        String [] emails = new String[] {
                "kate@gmail.com",
                "uncle@gmail.com",
                "hebert@gmail.com"
        };

        for (int i=0; i < names.length; i++) {
            authorService.updateAuthor(new FormAuthorDTO(
                    names[i],
                    emails[i],
                    null,
                    LocalDate.parse("1957/01/01", DateTimeFormatter.ofPattern("yyyy/MM/dd"))
            ));
        }

    }

    private void createBooks () {
        String[] title = new String[] {
                "Head First Java",
                "Java: A Beginner’s Guide",
                "C: The Complete Reference",
                "Teach Yourself C++",
                "Head First Servlets & JSP",
                "Clean code"

        };

        String [] email = new String[] {
                "kate@gmail.com",
                "hebert@gmail.com",
                "hebert@gmail.com",
                "hebert@gmail.com",
                "kate@gmail.com",
                "uncle@gmail.com",
        };

        String [] isbn = new String[] {
                "0596009208",
                "0-07-222588-2",
                "0-07-881313-1",
                "0-07-881760-9",
                "0596005407",
                "9780132350884"
        };

        for (int i=0; i < title.length; i++) {
            FormBookDTO book = new FormBookDTO();
            book.setTitle(title[i]);
            book.setIsbn(isbn[i]);
            book.setEmailOfAuthor(email[i]);
            book.setReleaseDate(LocalDate.parse("2021/01/01", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            book.setNumberOfPages(100);
            bookService.updateBook(book);
        }
    }
}

package com.bootcamp.library.api.repository;

import com.bootcamp.library.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

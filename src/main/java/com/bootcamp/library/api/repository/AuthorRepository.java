package com.bootcamp.library.api.repository;

import com.bootcamp.library.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

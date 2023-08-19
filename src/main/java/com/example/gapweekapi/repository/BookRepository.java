package com.example.gapweekapi.repository;

import com.example.gapweekapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookTitle(String bookTitle);
}

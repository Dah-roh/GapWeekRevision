package com.example.gapweekapi.service;

import com.example.gapweekapi.DTO.BookDTO;
import com.example.gapweekapi.model.Book;

public interface BookService {
       Book saveBook(BookDTO book);
       Book viewBook(Long id);
}

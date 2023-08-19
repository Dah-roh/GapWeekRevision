package com.example.gapweekapi.controller;

import com.example.gapweekapi.DTO.BookDTO;
import com.example.gapweekapi.Enum.Status;
import com.example.gapweekapi.model.Book;
import com.example.gapweekapi.service.BookService;
import com.example.gapweekapi.service.serviceImpl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @GetMapping("get-a-book/{id}")
    public ResponseEntity<Book> viewBook(@PathVariable Long id){
        return new ResponseEntity<>(bookService.viewBook(id), HttpStatus.OK);
    }

    @PostMapping("save-a-book")
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO book){
        BookDTO savedBook = new BookDTO(bookService.saveBook(book));
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }


}

package com.example.gapweekapi.service.serviceImpl;

import com.example.gapweekapi.DTO.BookDTO;
import com.example.gapweekapi.model.Book;
import com.example.gapweekapi.repository.BookRepository;
import com.example.gapweekapi.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    @Override
    public Book saveBook(BookDTO bookDTO) {
        return bookRepo.save(new Book(bookDTO));
    }
    @Override
    public Book viewBook(Long id) {
         return bookRepo.findById(id).orElseThrow(()->new RuntimeException("No such Book found with ID = "+ id));
    }

    @Override
    @Transactional()
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}

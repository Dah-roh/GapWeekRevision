package com.example.gapweekapi.controller;

import com.example.gapweekapi.DTO.BookDTO;
import com.example.gapweekapi.api.*;
import com.example.gapweekapi.config.ApiConfig;
import com.example.gapweekapi.model.Book;
import com.example.gapweekapi.service.BookService;
import com.example.gapweekapi.service.serviceImpl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("get-a-todo/{id}")
    public ResponseEntity<Book> todo(@PathVariable Long id){
//        Address address = Address.builder()
//                .id(1l)
//                .name("Orchid")
//                .build();
//        Bank bank = Bank.builder()
//                .id(1l)
//                .name("Orchid Bank").build();
//        Company company = Company.builder()
//                .id(1l)
//                .name("Orchid ltd")
//                .address(address).build();
//        Hair hair = Hair.builder()
//                .color("Brown")
//                .id(1l)
//                .type("Wooly")
//                .build();
//        User user = User.builder()
//                .company(company)
//                .bank(bank)
//                .hair(hair)
//                .id(1l)
//                .name("Orchid Daro")
//                .build();
//        System.out.println("This  is a sample: "+user);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        restTemplate.exchange("https://dummyjson.com/todos/"+id, HttpMethod.GET, httpEntity, Todo.class);
        return new ResponseEntity<>(bookService.viewBook(id), HttpStatus.OK);
    }

//
//    @GetMapping("get-a-book/{id}")
//    public ResponseEntity<Book> viewBook(@PathVariable Long id){
////        Address address = Address.builder()
////                .id(1l)
////                .name("Orchid")
////                .build();
////        Bank bank = Bank.builder()
////                .id(1l)
////                .name("Orchid Bank").build();
////        Company company = Company.builder()
////                .id(1l)
////                .name("Orchid ltd")
////                .address(address).build();
////        Hair hair = Hair.builder()
////                .color("Brown")
////                .id(1l)
////                .type("Wooly")
////                .build();
////        User user = User.builder()
////                .company(company)
////                .bank(bank)
////                .hair(hair)
////                .id(1l)
////                .name("Orchid Daro")
////                .build();
////        System.out.println("This  is a sample: "+user);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity httpEntity = new HttpEntity(httpHeaders);
//        restTemplate.exchange("https://dummyjson.com/todos/1", HttpMethod.GET, httpEntity, Todo.class);
//        return new ResponseEntity<>(bookService.viewBook(id), HttpStatus.OK);
//    }

    @PostMapping("save-a-book")
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO book){
        BookDTO savedBook = new BookDTO(bookService.saveBook(book));
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }


}

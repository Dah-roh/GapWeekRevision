package com.example.gapweekapi.controller;

import com.example.gapweekapi.DTO.BookDTO;
import com.example.gapweekapi.api.*;
import com.example.gapweekapi.config.ApiConfig;
import com.example.gapweekapi.model.Book;
import com.example.gapweekapi.service.BookService;
import com.example.gapweekapi.service.serviceImpl.BookServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("get-a-todo/{id}")
    public ResponseEntity<Todo> todo(@PathVariable Long id){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<Todo> todo = restTemplate.exchange("https://dummyjson.com/todos/"+id, HttpMethod.GET, httpEntity, Todo.class);
        return todo;
    }

    @GetMapping("get-mono-todo/{id}")
    public Mono<Todo> todoMono(@PathVariable Long id){
        return WebClient.create("https://dummyjson.com/todos/"+id).get().accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Todo.class);
    }

    @GetMapping("get-all-books/{pageNumber}")
    public PaginatedBooks allBooks(@PathVariable int pageNumber){
        PagedListHolder<Book> bookPagedListHolder = new PagedListHolder<Book>(bookService.getAllBooks());
        bookPagedListHolder.setPageSize(3);
        bookPagedListHolder.setPage(pageNumber);

        return PaginatedBooks.builder()
                .bookList(bookPagedListHolder.getPageList())
                .currentPage(bookPagedListHolder.getPage())
                .pageSize(bookPagedListHolder.getPageSize())
                .totalPages(bookPagedListHolder.getMaxLinkedPages())
                .build();
    }

    @GetMapping("get-todos/{id}")
    public List<Todo> todos(@PathVariable int id) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<String> todo = restTemplate.exchange("https://dummyjson.com/todos", HttpMethod.GET, httpEntity, String.class);
        List<Todo> todoList = new ObjectMapper().convertValue(new JSONParser(todo.getBody()).object().get("todos"),
                new TypeReference<List<Todo>>(){});
      return todoList;
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

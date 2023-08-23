package com.example.gapweekapi.api;

import com.example.gapweekapi.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginatedBooks {
    private List<Book> bookList;
    private int totalPages;
    private int currentPage;
    private int pageSize;
}

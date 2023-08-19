package com.example.gapweekapi.DTO;

import com.example.gapweekapi.Enum.Status;
import com.example.gapweekapi.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private Long id;
    private String bookTitle;
    private Status readStatus;
    private Double starRating;
    private Double personalRating;
    private String blurb;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.bookTitle = book.getBookTitle();
        this.readStatus = book.getReadStatus();
        this.starRating = book.getStarRating();
        this.personalRating = book.getPersonalRating();;
        this.blurb = book.getBlurb();
    }


}

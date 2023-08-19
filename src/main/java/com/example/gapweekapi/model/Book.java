package com.example.gapweekapi.model;

import com.example.gapweekapi.DTO.BookDTO;
import com.example.gapweekapi.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookTitle;
    @Enumerated
    private Status readStatus;
    private Double starRating;
    private Double personalRating;
    @Column(unique = true)
    private String blurb;

    public Book (BookDTO bookDTO) {
        this.id = bookDTO.getId();
        this.bookTitle = bookDTO.getBookTitle();
        this.readStatus = bookDTO.getReadStatus();
        this.starRating = bookDTO.getStarRating();
        this.personalRating = bookDTO.getPersonalRating();;
        this.blurb = bookDTO.getBlurb();
    }

}

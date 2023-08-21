package com.example.gapweekapi.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private Long id;
    private String todo;
    private Boolean completed;
    private Long userId;

}

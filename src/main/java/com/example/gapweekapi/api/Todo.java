package com.example.gapweekapi.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private Long id;
    private String todo;
    @JsonProperty("completed")
    private Boolean haveyouFinished;
    private Long userId;

}

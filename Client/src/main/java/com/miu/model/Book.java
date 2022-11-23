package com.miu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {


    private String isbn;
    private String title;
    private String description;
    private String authorName;

}

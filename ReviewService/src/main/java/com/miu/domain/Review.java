package com.miu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document

public class Review {

    @Id
    private int id;
    private String isbn;
    private int review;
    private String customerName;
    private String description;

    public Review(String isbn,int review,String customerName,String description){

        this.isbn = isbn;
        this.review = review;
        this.customerName = customerName;
        this.description = description;

    }
}

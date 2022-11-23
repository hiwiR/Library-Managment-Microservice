package com.miu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document

public class Borrowing {

    @Id
    private Integer borrowingNumber;
    private Date date;
    private Integer customernumber;
    private String customername;
    private String isbn;
    private String title;
}

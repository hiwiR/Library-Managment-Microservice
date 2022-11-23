package com.miu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BorrowingDto {

    private Integer borrowingNumber;
    private Date date;
    private Integer customernumber;
    private String customername;
    private String isbn;
    private String title;
}

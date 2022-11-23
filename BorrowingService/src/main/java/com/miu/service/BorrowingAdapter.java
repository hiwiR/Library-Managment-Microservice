package com.miu.service;

import com.miu.domain.Borrowing;
import com.miu.service.dto.BorrowingDto;

public class BorrowingAdapter {
    public static BorrowingDto getBorrowingDto(Borrowing borrowing){
        BorrowingDto borrowingDto = new BorrowingDto(
                borrowing.getBorrowingNumber(),
                borrowing.getDate(),
                borrowing.getCustomernumber(),
                borrowing.getCustomername(),
                borrowing.getIsbn(),
                borrowing.getTitle()

        );
        return borrowingDto;
    }
}

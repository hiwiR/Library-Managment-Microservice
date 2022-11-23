package com.miu.service;

import com.miu.domain.Borrowing;
import com.miu.service.dto.BookDto;
import com.miu.service.dto.CustomerDto;

public interface BorrowingService {
    void add(BorrowRequest borrowRequest);

    Borrowing getBorrowing(int borrowingNumber);

    void updateCustomer(CustomerDto customerDto);

    void updateBook(BookDto bookDto);
}

package com.miu.service;

import com.miu.domain.BookQuery;
import com.miu.service.dto.BookDto;
import com.miu.service.dto.BookQueryDto;
import com.miu.service.dto.ReviewDto;

import java.util.List;

public interface BookQueryService {
    boolean bookExist(String isbn);

    BookQueryDto getBook(String isbn);

    void addBood(BookDto bookDto);

    void updateBookInfo(BookDto bookDto);

    void updateBookReview(ReviewDto reviewDto);

    List<BookQueryDto> getAllBooks();
}

package com.miu.service.dto;

import com.miu.domain.BookQuery;

public class BookQueryAdapter {

    public static BookQuery getBookQuery(BookQueryDto bookQueryDto){
        BookQuery bookQuery =  new BookQuery(
                bookQueryDto.getIsbn(),
                bookQueryDto.getTitle(),
                bookQueryDto.getDescription(),
                bookQueryDto.getAuthorName(),
                bookQueryDto.getReviews()

        );
        return bookQuery;
    }

    public static BookQueryDto getBookQueryDto(BookQuery bookQuery){
        BookQueryDto bookQueryDto =  new BookQueryDto(
                bookQuery.getIsbn(),
                bookQuery.getTitle(),
                bookQuery.getDescription(),
                bookQuery.getAuthorName(),
                bookQuery.getReviews()
        );
        return bookQueryDto;
    }
}

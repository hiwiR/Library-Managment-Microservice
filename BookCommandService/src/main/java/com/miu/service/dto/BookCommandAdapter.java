package com.miu.service.dto;

import com.miu.domain.Book;

public class BookCommandAdapter {
    public static Book getBookCommand(BookDto bookDto){
        Book book = new Book(
                bookDto.getIsbn(),
                bookDto.getTitle(),
                bookDto.getAuthorName(),
                bookDto.getDescription()
        );
        return book;
    }
    public static BookDto getBookDto(Book book){
        BookDto bookDto = new BookDto(
                book.getIsbn(),
                book.getTitle(),
                book.getDescription(),
                book.getAuthorName()
        );
        return bookDto;
    }
}

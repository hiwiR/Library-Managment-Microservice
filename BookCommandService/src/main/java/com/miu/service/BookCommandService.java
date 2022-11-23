package com.miu.service;

import com.miu.service.dto.BookDto;

public interface BookCommandService {

    boolean bookExist(String isbn);

    void addBook(BookDto book);

    void updateBook(BookDto book);

    void deleteBook(String isbn);
}

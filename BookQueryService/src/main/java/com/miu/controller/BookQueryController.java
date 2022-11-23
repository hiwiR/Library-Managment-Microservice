package com.miu.controller;

import com.miu.domain.Book;
import com.miu.domain.BookQuery;
import com.miu.service.Books;
import com.miu.service.dto.BookDto;
import com.miu.service.BookQueryService;
import com.miu.service.dto.BookQueryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookQueryController {
    private BookQueryService bookQueryService;

    public BookQueryController(BookQueryService bookQueryService){
        this.bookQueryService = bookQueryService;
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn){
        if(!bookQueryService.bookExist(isbn))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        BookQueryDto bookdto = bookQueryService.getBook(isbn);
        return new ResponseEntity<>(bookdto,HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllBook(){
        List<BookQueryDto> bookList = bookQueryService.getAllBooks();
        Books books = new Books(bookList);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }
}

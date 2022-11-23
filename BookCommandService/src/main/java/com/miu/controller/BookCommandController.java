package com.miu.controller;

import com.miu.service.BookCommandService;
import com.miu.service.dto.BookDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookcommand")
public class BookCommandController {

    private BookCommandService bookCommandService;
    private ModelMapper modelMapper;

    public BookCommandController(BookCommandService bookCommandService, ModelMapper modelMapper){

        this.bookCommandService = bookCommandService;
        this.modelMapper = modelMapper;
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn){
        bookCommandService.deleteBook(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookDto bookdto){
        bookCommandService.addBook(bookdto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody BookDto bookdto){
        if(!bookCommandService.bookExist(bookdto.getIsbn()))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        bookCommandService.updateBook(bookdto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

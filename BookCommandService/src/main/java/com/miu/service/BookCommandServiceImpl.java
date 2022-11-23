package com.miu.service;

import com.miu.data.BookCommandRepository;
import com.miu.domain.Book;
import com.miu.integration.KafkaSender;
import com.miu.service.dto.BookCommandAdapter;
import com.miu.service.dto.BookDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookCommandServiceImpl implements BookCommandService{

    private BookCommandRepository bookCommandRepository;
    private KafkaSender kafkaSender;
    private ModelMapper modelMapper;
    public BookCommandServiceImpl(BookCommandRepository bookCommandRepository,ModelMapper modelMapper,KafkaSender kafkaSender){
        this.bookCommandRepository = bookCommandRepository;
        this.modelMapper = modelMapper;
        this.kafkaSender = kafkaSender;
    }


    @Override
    public boolean bookExist(String isbn) {
        return bookCommandRepository.existsById(isbn);
    }

    @Override
    public void addBook(BookDto bookdto) {
        Book book= BookCommandAdapter.getBookCommand(bookdto);
                //modelMapper.map(bookdto,Book.class);
        bookCommandRepository.save(book);
        kafkaSender.send("addbook-topic",bookdto);
    }

    @Override
    public void updateBook(BookDto bookdto) {
        Book book1= BookCommandAdapter.getBookCommand(bookdto);
                //modelMapper.map(bookdto,Book.class);
        bookCommandRepository.save(book1);
        kafkaSender.send("updatebook-topic",bookdto);
        kafkaSender.send("updateborrowed-book1",bookdto);
    }

    @Override
    public void deleteBook(String isbn) {
        bookCommandRepository.deleteById(isbn);
        kafkaSender.send("deletebook-topic",BookCommandAdapter.getBookDto(bookCommandRepository.findById(isbn).get()));
                //modelMapper.map(bookCommandRepository.findById(isbn).get(),BookDto.class));
        //kafkaSender.send("updatebook-topic",bookdto);
    }

}

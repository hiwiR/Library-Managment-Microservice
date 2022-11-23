package com.miu.service;

import com.miu.data.BookQueryRepository;
import com.miu.domain.Book;
import com.miu.domain.BookQuery;
import com.miu.domain.Review;
import com.miu.service.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookQueryService{

    private BookQueryRepository bookQueryRepository;
    private ModelMapper modelMapper;

    public BookServiceImpl(BookQueryRepository bookQueryRepository,ModelMapper modelMapper){
        this.bookQueryRepository = bookQueryRepository;
        this.modelMapper =  modelMapper;
    }

    @Override
    public boolean bookExist(String isbn) {
        return bookQueryRepository.existsById(isbn);
    }

    @Override
    public BookQueryDto getBook(String isbn) {
        BookQuery bookQuery = bookQueryRepository.findById(isbn).get();
        BookQueryDto bookQueryDto = BookQueryAdapter.getBookQueryDto(bookQuery);
               // modelMapper.map(bookQuery,BookDto.class);
        return bookQueryDto;

    }

    @Override
    public void addBood(BookDto bookDto) {
        BookQuery bookQuery = modelMapper.map(bookDto,BookQuery.class);
        bookQueryRepository.save(bookQuery);
    }

    @Override
    public void updateBookInfo(BookDto bookDto) {
        BookQuery bookQuery = modelMapper.map(bookDto,BookQuery.class);
        BookQuery bk = bookQueryRepository.findById(bookDto.getIsbn()).orElseThrow();
//        bk.setTitle(bookDto.getTitle());
//        bk.setDescription(bookDto.getDescription());
        bookQuery.setReviews(bk.getReviews());
        bookQueryRepository.save(bookQuery);
    }

    @Override
    public void updateBookReview(ReviewDto reviewDto) {
        BookQuery bk = bookQueryRepository.findById(reviewDto.getIsbn()).get();
        List<Review> reviews = bk.getReviews();
        if(reviews == null) {
            bk.setReviews(Arrays.asList(ReviewAdapter.getReview(reviewDto)));
            bookQueryRepository.save(bk);
        }else{
            reviews.add(ReviewAdapter.getReview(reviewDto));
            bk.setReviews(reviews);
            bookQueryRepository.save(bk);
        }
    }

    @Override
    public List<BookQueryDto> getAllBooks() {
        List<BookQuery> bookQueries = bookQueryRepository.findAll();
        List<BookQueryDto> books= bookQueries.stream().map(bookQuery -> {
            BookQueryDto bk = BookQueryAdapter.getBookQueryDto(bookQuery);
            return bk;
        }).collect(Collectors.toList());
        return books;

    }
}

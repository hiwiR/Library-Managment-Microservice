package com.miu.integration;

import com.miu.service.dto.BookDto;
import com.miu.service.BookQueryService;
import com.miu.service.dto.ReviewDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiver {

    private BookQueryService bookQueryService;

    public KafkaReceiver(BookQueryService bookQueryService){
        this.bookQueryService = bookQueryService;
    }

    @KafkaListener(topics = "addbook-topic")
    public void recieve(@Payload BookDto bookDto){
        System.out.println("New Book added" + bookDto.toString());
        bookQueryService.addBood(bookDto);
    }

    @KafkaListener(topics = "updatebook-topic")
    public void updateBook(@Payload BookDto bookDto){
        System.out.println("Book info update" + bookDto.toString());
        bookQueryService.updateBookInfo(bookDto);
    }
    @KafkaListener(topics = "reviewadded-topic")
    public void addReview(@Payload ReviewDto reviewDto){
        bookQueryService.updateBookReview(reviewDto);
    }


}

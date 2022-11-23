package com.miu.integration;

import com.miu.service.BorrowingService;

import com.miu.service.dto.BookDto;
import com.miu.service.dto.CustomerDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiver {

    private BorrowingService borrowingService;

    public KafkaReceiver(BorrowingService borrowingService){
        
        this.borrowingService = borrowingService;
    }

    @KafkaListener(topics = "customerupdate")
    public void recieve(@Payload CustomerDto customerDto){
        System.out.println("update customer" + customerDto.toString());
        borrowingService.updateCustomer(customerDto);
    }
    @KafkaListener(topics = "updateborrowed-book1")
    public void recieveBookUpdate(@Payload BookDto bookDto){
        borrowingService.updateBook(bookDto);
    }
}

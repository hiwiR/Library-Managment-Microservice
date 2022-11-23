package com.miu.service;

import com.miu.data.BorrowingRepository;
import com.miu.domain.Borrowing;
import com.miu.service.dto.BookDto;
import com.miu.service.dto.BookQueryDto;
import com.miu.service.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BorrowingServiceImpl implements BorrowingService{

    private BorrowingRepository borrowingRepository;
    private RestTemplate restTemplate;
    private CustomerData customerData;
    private BookData bookData;
    private NextSequenceService nextSequenceService;

    public BorrowingServiceImpl(BorrowingRepository borrowingRepository,RestTemplate restTemplate,CustomerData customerData,
                                BookData bookData,NextSequenceService nextSequenceService){
        this.borrowingRepository = borrowingRepository;
        this.restTemplate = restTemplate;
        this.customerData = customerData;
        this.bookData = bookData;
        this.nextSequenceService = nextSequenceService;

    }

    @Override
    public void add(BorrowRequest borrowRequest) {
        CustomerDto customerDto = customerData.findCustomer(borrowRequest.getCustomerNumber());
        BookQueryDto bookQueryDto = bookData.findBook(borrowRequest.getIsbn());
        Borrowing borrowing = new Borrowing();
        borrowing.setBorrowingNumber(nextSequenceService.getNextSequence("customSequences"));
        borrowing.setIsbn(bookQueryDto.getIsbn());
        Date now = new Date();
        borrowing.setDate(now);
        borrowing.setTitle(bookQueryDto.getTitle());
        borrowing.setCustomername(customerDto.getFirstName()+" "+customerDto.getLastName());
        borrowing.setCustomernumber(customerDto.getCustomerNumber());
        //System.out.println(bookQueryDto);
        borrowingRepository.save(borrowing);

    }

    @Override
    public Borrowing getBorrowing(int borrowingNumber) {
        return null;
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        System.out.println();
        List<Borrowing> borrowingList = borrowingRepository.findAllByCustomernumber(customerDto.getCustomerNumber());
        List<Borrowing> test = borrowingList.stream().map(borrowing -> {
            borrowing.setCustomername(customerDto.getFirstName()+" "+customerDto.getLastName());
            borrowing.setDate(borrowing.getDate());
            return borrowing;
        }).collect(Collectors.toList());
        borrowingRepository.saveAll(test);

    }

    @Override
    public void updateBook(BookDto bookDto) {
        List<Borrowing> borrowingList = borrowingRepository.findAllByIsbn(bookDto.getIsbn());
        List<Borrowing> test = borrowingList.stream().map(borrowing -> {
            borrowing.setTitle(bookDto.getTitle());
            borrowing.setIsbn(bookDto.getIsbn());
            return borrowing;
        }).collect(Collectors.toList());
        borrowingRepository.saveAll(test);
    }

    @FeignClient( name = "ClientService")
     interface CustomerData{
        @RequestMapping("/customer/{customerNumber}")
        public CustomerDto findCustomer(@PathVariable int customerNumber);

    }
    @FeignClient( name = "BookQueryService")
    interface BookData{
        @RequestMapping("/books/{isbn}")
        public BookQueryDto findBook(@PathVariable String isbn);

    }
}

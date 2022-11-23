package com.miu.controller;

import com.miu.domain.Borrowing;
import com.miu.service.BorrowRequest;
import com.miu.service.BorrowingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService){

        this.borrowingService = borrowingService;
    }
    @PostMapping()
    public void addBorrowing(@RequestBody BorrowRequest borrowRequest){
        borrowingService.add(borrowRequest);
    }
    @GetMapping("/{borrowingNumber}")
    public Borrowing getBorrowing(@PathVariable int borrowingNumber){
        return borrowingService.getBorrowing(borrowingNumber);
    }
}

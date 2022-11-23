package com.miu.web;

import com.miu.domain.Review;
import com.miu.service.ReviewService;
import com.miu.service.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @PostMapping()
    public void addReview(@RequestBody Review review){
        reviewService.add(review);
    }
    @GetMapping("/books/{isbn}")
    public Reviews getReview(@PathVariable String isbn){
        return reviewService.getReview(isbn);
    }
}

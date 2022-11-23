package com.miu.service;

import com.miu.domain.Review;

public interface ReviewService {
    void add(Review review);

    Reviews getReview(String isbn);
}

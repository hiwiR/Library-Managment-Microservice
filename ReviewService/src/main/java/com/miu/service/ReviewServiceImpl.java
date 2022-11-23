package com.miu.service;

import com.miu.data.ReviewRepository;
import com.miu.domain.Review;
import com.miu.integration.KafkaSender;
import com.miu.service.dto.ReviewAdapter;
import com.miu.service.dto.ReviewDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private ModelMapper modelMapper;
    private KafkaSender kafkaSender;

    private NextSequenceService nextSequenceService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ModelMapper modelMapper
        ,KafkaSender kafkaSender,NextSequenceService nextSequenceService){
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
        this.kafkaSender = kafkaSender;
        this.nextSequenceService = nextSequenceService;
    }
    @Override
    public void add(Review review) {
        review.setId(nextSequenceService.getNextSequence("customSequences"));
        reviewRepository.save(review);
        ReviewDto reviewDto = ReviewAdapter.getReviewDto(review);
                //modelMapper.map(review,ReviewDto.class);
        kafkaSender.send("reviewadded-topic",reviewDto);
    }

    @Override
    public Reviews getReview(String isbn) {
        List<Review> reviewList = reviewRepository.findAllByIsbn(isbn);
        List<ReviewDto> reviewDtos= reviewList.stream().map( review ->
                ReviewAdapter.getReviewDto(review)).collect(Collectors.toList());
                //modelMapper.map(review,ReviewDto.class)).collect(Collectors.toList());
        Reviews reviews =  new Reviews(reviewDtos);
        return  reviews;
    }

}

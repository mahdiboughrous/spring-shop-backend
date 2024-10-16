package com.boughrous.productcompositeservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boughrous.productcompositeservice.clients.ReviewClient;
import com.boughrous.productcompositeservice.dto.CreateReviewRequest;
import com.boughrous.productcompositeservice.models.Review;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewClient reviewClient;

    // get all reviews 
    public List<Review> getAllReviews() {
        return reviewClient.getAllReviews();
    }

    // get review by id
    public Review getReviewById(int id) {
        return reviewClient.getReviewById(id);
    }

    // create review
    public void createReview(CreateReviewRequest review) {
        reviewClient.createReview(review);
    }
}

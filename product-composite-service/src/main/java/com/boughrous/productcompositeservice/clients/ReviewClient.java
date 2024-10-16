package com.boughrous.productcompositeservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.boughrous.productcompositeservice.dto.CreateReviewRequest;
import com.boughrous.productcompositeservice.models.Review;

@FeignClient(name = "review-service")
public interface  ReviewClient {

    // get all reviews
    @GetMapping("/reviews")
    List<Review> getAllReviews();

    // get review by id
    @GetMapping("/reviews/{id}")
    Review getReviewById(int id);

    // create review
    @PostMapping("/reviews")
    void createReview(CreateReviewRequest review);
    
}

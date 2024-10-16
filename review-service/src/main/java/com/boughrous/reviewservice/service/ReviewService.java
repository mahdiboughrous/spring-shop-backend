package com.boughrous.reviewservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boughrous.reviewservice.model.Review;
import com.boughrous.reviewservice.repository.IReviewRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewService {

    @Autowired
    private IReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(int id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.orElse(null);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(int id, Review reviewDetails) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();

            review.setProductId(reviewDetails.getProductId());
            review.setSubject(reviewDetails.getSubject());
            review.setAuthor(reviewDetails.getAuthor());
            review.setContent(reviewDetails.getContent());
            
            return reviewRepository.save(review);
        } else {
            return null;
        }
    }

    public boolean deleteReview(int id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            reviewRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

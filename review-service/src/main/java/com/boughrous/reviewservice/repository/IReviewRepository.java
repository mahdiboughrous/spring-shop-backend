package com.boughrous.reviewservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boughrous.reviewservice.model.Review;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> {}
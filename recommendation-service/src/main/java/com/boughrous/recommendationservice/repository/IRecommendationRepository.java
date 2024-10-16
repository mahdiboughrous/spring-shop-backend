package com.boughrous.recommendationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boughrous.recommendationservice.model.Recommendation;

@Repository
public interface IRecommendationRepository extends JpaRepository<Recommendation, Integer> {}
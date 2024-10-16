package com.boughrous.recommendationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boughrous.recommendationservice.dto.CreateRecommendationRequest;
import com.boughrous.recommendationservice.model.Recommendation;
import com.boughrous.recommendationservice.repository.IRecommendationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecommendationService {

    @Autowired
    private IRecommendationRepository recommendationRepository;

    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    public Recommendation getRecommendationById(int id) {
        Optional<Recommendation> recommendation = recommendationRepository.findById(id);
        return recommendation.orElse(null);
    }

    public Recommendation createRecommendation(Recommendation recommendation) {

        return recommendationRepository.save(recommendation);
    }

    public Recommendation updateRecommendation(int id, Recommendation recommendationDetails) {
        Optional<Recommendation> recommendationOptional = recommendationRepository.findById(id);
        if (recommendationOptional.isPresent()) {

            Recommendation recommendation = recommendationOptional.get();
            recommendation.setAuthor(recommendationDetails.getAuthor());
            recommendation.setProductId(recommendationDetails.getProductId());
            recommendation.setRate(recommendationDetails.getRate());
            recommendation.setContent(recommendationDetails.getContent());

            return recommendationRepository.save(recommendation);
        } else {
            return null;
        }
    }

    public boolean deleteRecommendation(int id) {
        Optional<Recommendation> recommendationOptional = recommendationRepository.findById(id);
        if (recommendationOptional.isPresent()) {
            recommendationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

package com.boughrous.productcompositeservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.boughrous.productcompositeservice.dto.CreateRecommendationRequest;
import com.boughrous.productcompositeservice.models.Recommendation;


@FeignClient(name = "recommendation-service")
public interface RecommendationClient {

    // get all recommendations
    @GetMapping("/recommendations")
    List<Recommendation> getAllRecommendations();

    // get recommendation by id
    @GetMapping("/recommendations/{id}")
    Recommendation getRecommendationById(int id);

    // create recommendation
    @PostMapping("/recommendations")
    void createRecommendation(CreateRecommendationRequest recommendation);
}

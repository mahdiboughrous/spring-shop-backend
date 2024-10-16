package com.boughrous.recommendationservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boughrous.recommendationservice.dto.CreateRecommendationRequest;
import com.boughrous.recommendationservice.model.Recommendation;
import com.boughrous.recommendationservice.service.RecommendationService;



@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;


    @GetMapping
    public ResponseEntity<List<Recommendation>> getAllRecommendations() {
        List<Recommendation> recommendations = recommendationService.getAllRecommendations();
        return ResponseEntity.ok().body(recommendations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recommendation> getRecommendationById(@PathVariable int id) {

        Recommendation recommendation = recommendationService.getRecommendationById(id);

        return ResponseEntity.ok().body(recommendation);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createRecommendation(@RequestBody CreateRecommendationRequest newRecommendation) {

        Recommendation recommendation = new Recommendation(newRecommendation.getProductId(), newRecommendation.getAuthor(), newRecommendation.getRate(), newRecommendation.getContent());

        recommendationService.createRecommendation(recommendation);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Recommendation created successfully");
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recommendation> updateRecommendation(@PathVariable int id, @RequestBody Recommendation recommendationDetails) {
        // Return updated mock data
        Recommendation updatedRecommendation = new Recommendation(id, recommendationDetails.getProductId(), recommendationDetails.getAuthor(), recommendationDetails.getRate(), recommendationDetails.getContent());
        recommendationService.updateRecommendation(id, recommendationDetails);
        return ResponseEntity.ok(updatedRecommendation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable int id) {

        recommendationService.deleteRecommendation(id);

        return ResponseEntity.noContent().build();
    }
}
package com.boughrous.productcompositeservice.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductCompositeService {

    private final ProductService productService;
    private final ReviewService reviewService;
    private final RecommendationService recommendationService;

    // TODO: Implement aggregate methods later

}

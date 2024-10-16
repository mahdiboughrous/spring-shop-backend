package com.boughrous.productcompositeservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.boughrous.productcompositeservice.models.Product;
import com.boughrous.productcompositeservice.models.ProductComposite;
import com.boughrous.productcompositeservice.models.Recommendation;
import com.boughrous.productcompositeservice.models.Review;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductCompositeService {

    private final ProductService productService;
    private final ReviewService reviewService;
    private final RecommendationService recommendationService;

    // aggregate data from different services
    public List<ProductComposite> getAllProductComposites() {
        List<Product> products = productService.getAllProducts();
        List<Review> reviews = reviewService.getAllReviews();
        List<Recommendation> recommendations = recommendationService.getAllRecommendations();

        // aggregating products, reviews, and recommenadtions
        List<ProductComposite> productComposites = products.stream().map(product -> {
            // filter reviews based on the product ID
            List<Review> productReviews = reviews.stream()
                    .filter(review -> review.getProductId() == product.getId())
                    .collect(Collectors.toList());

            // filter recommendations based on the product
            List<Recommendation> productRecommendations = recommendations.stream()
                    .filter(recommendation -> recommendation.getProductId() == product.getId())
                    .collect(Collectors.toList());

            return new ProductComposite(product, productReviews, productRecommendations);
        }).collect(Collectors.toList());

        return productComposites;
    }
}

package com.boughrous.productcompositeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boughrous.productcompositeservice.dto.CreateProductRequest;
import com.boughrous.productcompositeservice.dto.CreateRecommendationRequest;
import com.boughrous.productcompositeservice.dto.CreateReviewRequest;
import com.boughrous.productcompositeservice.models.Product;
import com.boughrous.productcompositeservice.models.ProductComposite;
import com.boughrous.productcompositeservice.models.Recommendation;
import com.boughrous.productcompositeservice.models.Review;
import com.boughrous.productcompositeservice.service.ProductCompositeService;
import com.boughrous.productcompositeservice.service.ProductService;
import com.boughrous.productcompositeservice.service.RecommendationService;
import com.boughrous.productcompositeservice.service.ReviewService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/product-composites")
public class ProductCompositeController {

    @Autowired
    private final ProductCompositeService productCompositeService;
    private final ProductService productService;
    private final ReviewService reviewService;
    private final RecommendationService recommendationService;
    private final Logger logger = LoggerFactory.getLogger(ProductCompositeController.class); 

    // get all product composites
    @GetMapping
    public ResponseEntity<List<ProductComposite>> getAllProductComposites() {
        logger.info("Getting all product composites");
        List<ProductComposite> productComposites = productCompositeService.getAllProductComposites();
        return ResponseEntity.ok().body(productComposites);
    }

    // get all products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        logger.info("Getting all products");
        List<Product> products =  productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    // get product by id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@RequestParam int id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok().body(product);
    }

    // create product
    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@RequestBody CreateProductRequest product) {
        productService.createProduct(product);
        return ResponseEntity.ok().build();
    }

    // get all reviews
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok().body(reviews);
    }

    // get review by id
    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewById(@RequestParam int id) {
        Review review = reviewService.getReviewById(id);
        return ResponseEntity.ok().body(review);
    }

    // create review
    @PostMapping("/reviews")
    public ResponseEntity<Void> createReview(@RequestBody CreateReviewRequest review) {
        reviewService.createReview(review);
        return ResponseEntity.ok().build();
    }

    // get all recommendations
    @GetMapping("/recommendations")
    public ResponseEntity<List<Recommendation>> getAllRecommendations() {
        List<Recommendation> recommendations = recommendationService.getAllRecommendations();
        return ResponseEntity.ok().body(recommendations);
    }

    // get recommendation by id
    @GetMapping("/recommendations/{id}")
    public ResponseEntity<Recommendation> getRecommendationById(@RequestParam int id) {
        Recommendation recommendation = recommendationService.getRecommendationById(id);
        return ResponseEntity.ok().body(recommendation);
    }

    // create recommendation
    @PostMapping("/recommendations")
    public ResponseEntity<Void> createRecommendation(@RequestBody CreateRecommendationRequest recommendation) {
        recommendationService.createRecommendation(recommendation);
        return ResponseEntity.ok().build();
    }
}
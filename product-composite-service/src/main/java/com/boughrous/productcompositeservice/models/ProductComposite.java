package com.boughrous.productcompositeservice.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductComposite {

    private Product product;
    private List<Recommendation> recommendations;
    private List<Review> reviews;

    // Constructor to initialize all fields
    public ProductComposite(Product product, List<Review> reviews, List<Recommendation> recommendations) {
        this.product = product;
        this.recommendations = recommendations;
        this.reviews = reviews;
    }
}

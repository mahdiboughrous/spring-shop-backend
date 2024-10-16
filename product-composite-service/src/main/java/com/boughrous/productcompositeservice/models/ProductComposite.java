package com.boughrous.productcompositeservice.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ProductComposite extends Product{

    private List<Recommendation> recommendations;
    private List<Review> reviews;
    
}

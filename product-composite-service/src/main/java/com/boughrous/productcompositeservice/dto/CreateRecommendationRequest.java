package com.boughrous.productcompositeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateRecommendationRequest {

    private int productId;
    private String author;
    private Double rate;
    private String content;


}
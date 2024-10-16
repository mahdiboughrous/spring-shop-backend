package com.boughrous.recommendationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int productId;
    private String author;
    private Double rate;
    private String content;

    public Recommendation(int productId, String author, Double rate, String content) {
        this.productId = productId;
        this.author = author;
        this.rate = rate;
        this.content = content;
    }
}


package com.boughrous.productcompositeservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Recommendation {
    private int id;
    private int productId;
    private String author;
    private double rate;
    private String content;
}

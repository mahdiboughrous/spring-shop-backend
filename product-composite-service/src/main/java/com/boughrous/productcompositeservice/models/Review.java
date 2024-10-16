package com.boughrous.productcompositeservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    private int id;
    private int productId;
    private String author;
    private String subject;
    private String content;
}

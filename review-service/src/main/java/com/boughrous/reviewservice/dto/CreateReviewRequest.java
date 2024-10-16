package com.boughrous.reviewservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateReviewRequest {

    private int productId;
    private String author;
    private String subject;
    private String content;

}
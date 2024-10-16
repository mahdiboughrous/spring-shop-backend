package com.boughrous.productcompositeservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.boughrous.productcompositeservice.dto.CreateProductRequest;
import com.boughrous.productcompositeservice.models.Product;

@FeignClient(name = "product-service")
public interface ProductClient {


    // get all products
    @GetMapping("/products")
    List<Product> getAllProducts();

    // get product by id
    @GetMapping("/products/{id}")
    Product getProductById(int id);

    // create product
    @PostMapping("/products")
    void createProduct(CreateProductRequest product);

}

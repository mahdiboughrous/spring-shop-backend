package com.boughrous.productcompositeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boughrous.productcompositeservice.clients.ProductClient;
import com.boughrous.productcompositeservice.dto.CreateProductRequest;
import com.boughrous.productcompositeservice.models.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private final ProductClient productClient;

    // get all products
    public List<Product> getAllProducts() {
        return productClient.getAllProducts();
    }

    // get product by id
    public Product getProductById(int id) {
        return productClient.getProductById(id);
    }

    // create product
    public void createProduct(CreateProductRequest product) {
        productClient.createProduct(product);
    }

}

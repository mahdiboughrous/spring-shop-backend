package com.boughrous.product_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boughrous.product_service.dto.CreateProductRequest;
import com.boughrous.product_service.model.Product;
import com.boughrous.product_service.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    public List<Product> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            logger.info(products.get(0).toString());
        }

        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {

        Product product = productService.getProductById(id);

        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createProduct(@RequestBody CreateProductRequest newProduct) {

        Product product = new Product(newProduct.getName(), newProduct.getWeight());

        productService.createProduct(product);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Product created successfully");
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
        // Return updated mock data
        Product updatedProduct = new Product(id, productDetails.getName(),  productDetails.getWeight());
        productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }
}
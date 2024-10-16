package com.boughrous.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.boughrous.product_service.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {}
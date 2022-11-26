package com.portal.server.repository;

import com.portal.server.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    void addProduct(Product product);
    Product getById(Long id);
    void addProduct(Product product, Long categoryId);

    List<Product> getAllProducts();
}

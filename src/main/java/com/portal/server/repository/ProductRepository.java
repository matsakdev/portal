package com.portal.server.repository;

import com.portal.server.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
    void addProduct(Product product);
    Product getById(Long id);
    void addProduct(Product product, Long categoryId);
}

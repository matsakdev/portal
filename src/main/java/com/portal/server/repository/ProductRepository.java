package com.portal.server.repository;

import com.portal.server.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository {
    void addProduct(Product product);
    Product getById(Long id);
    void addProduct(Product product, Long categoryId);

    List<Product> getAllProducts();

    Set<Product> getAllByCategory(Long categoryId);
}

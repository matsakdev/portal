package com.portal.server.dao;

import com.portal.server.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface ProductDAO {
    void save(Product product);
    Product getById(Long id);
    List<Product> getAll();

    Set<Product> getAllProductsByCategory(Long categoryId);
}

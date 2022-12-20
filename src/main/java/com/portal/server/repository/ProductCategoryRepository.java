package com.portal.server.repository;

import com.portal.server.entity.Product;
import com.portal.server.entity.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductCategoryRepository {
    void save(ProductCategory productCategory);
    ProductCategory getById(Long id);

    Set<ProductCategory> getAll();
}

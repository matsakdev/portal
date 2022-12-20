package com.portal.server.repository;

import com.portal.server.entity.Product;
import com.portal.server.entity.ProductCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository {
    void save(ProductCategory productCategory);
    ProductCategory getById(Long id);
}

package com.portal.server.dao;

import com.portal.server.entity.ProductCategory;

import java.util.Set;


public interface ProductCategoryDAO {
    void save(ProductCategory productCategory);
    ProductCategory getById(Long id);

    Set<ProductCategory> getAllCategories();
}

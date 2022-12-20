package com.portal.server.dao;

import com.portal.server.entity.ProductCategory;


public interface ProductCategoryDAO {
    void save(ProductCategory productCategory);
    ProductCategory getById(Long id);
}

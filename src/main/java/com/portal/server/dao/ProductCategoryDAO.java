package com.portal.server.dao;

import com.portal.server.controller.ProductCategoryRepository;
import com.portal.server.entity.ProductCategory;
import org.springframework.stereotype.Component;


public interface ProductCategoryDAO {
    void save(ProductCategory productCategory);
    ProductCategory getById(Long id);
}

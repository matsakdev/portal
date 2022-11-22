package com.portal.server.controller;

import com.portal.server.dao.ProductCategoryDAO;
import com.portal.server.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {

    @Autowired
    ProductCategoryDAO productCategoryDAO;


    @Override
    public void save(ProductCategory productCategory) {
        productCategoryDAO.save(productCategory);
    }

    @Override
    public ProductCategory getById(Long id) {
        return productCategoryDAO.getById(id);
    }
}

package com.portal.server.repository;

import com.portal.server.dao.ProductCategoryDAO;
import com.portal.server.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
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

    @Override
    public Set<ProductCategory> getAll() {
        return productCategoryDAO.getAllCategories();
    }
}

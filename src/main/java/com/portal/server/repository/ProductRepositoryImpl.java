package com.portal.server.repository;

import com.portal.server.dao.ProductCategoryDAO;
import com.portal.server.dao.ProductDAO;
import com.portal.server.entity.Product;
import com.portal.server.entity.ProductCategory;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProductCategoryDAO productCategoryDAO;

    @Override
    public void addProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productDAO.getById(id);
    }

    @Override
    public void addProduct(Product product, Long categoryId) {
        ProductCategory productCategory = productCategoryDAO.getById(categoryId);
        product.setCategory(productCategory);
        addProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }
}

package com.portal.server.dao;

import com.portal.server.controller.ProductCategoryRepository;
import com.portal.server.entity.ProductCategory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Component
public class ProductCategoryDAOImpl implements ProductCategoryDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(ProductCategory productCategory) {
        entityManager.persist(productCategory);
    }

    @Override
    public ProductCategory getById(Long id) {
        return entityManager.find(ProductCategory.class, id);
    }
}

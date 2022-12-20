package com.portal.server.dao;

import com.portal.server.entity.ProductCategory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

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

    @Override
    public Set<ProductCategory> getAllCategories() {
        return Set.copyOf(entityManager.createQuery("SELECT category FROM ProductCategory category").getResultList());
    }
}

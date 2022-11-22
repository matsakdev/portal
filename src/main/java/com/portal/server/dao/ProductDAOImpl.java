package com.portal.server.dao;

import com.portal.server.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public Product getById(Long id) {
        return entityManager.find(Product.class, id);
    }
}

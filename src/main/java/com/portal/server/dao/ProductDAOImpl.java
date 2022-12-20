package com.portal.server.dao;

import com.portal.server.entity.Dish;
import com.portal.server.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

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

    @Override
    @Transactional
    public List<Product> getAll() {
        return entityManager
                .createQuery("SELECT p FROM Product p")
                .getResultList();
    }

    @Override
    public Set<Product> getAllProductsByCategory(Long categoryId) {
        Query query = entityManager.createQuery("SELECT prod FROM Product prod WHERE prod.category.id=" + categoryId);
        List<Product> products = query.getResultList();
        return Set.copyOf(products);
    }
}

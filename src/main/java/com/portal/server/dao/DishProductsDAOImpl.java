package com.portal.server.dao;

import com.portal.server.entity.Dish;
import com.portal.server.entity.DishProduct;
import com.portal.server.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Set;
import java.util.stream.Collectors;

public class DishProductsDAOImpl implements DishProductsDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(DishProduct dishProduct) {
        entityManager.persist(dishProduct);
    }

    @Override
    public Set<DishProduct> getByDish(Dish dish) {
        Query query = entityManager.createQuery("SELECT dp FROM DishProduct dp WHERE dp.dish.id = " + dish.getId());
        return (Set<DishProduct>) query.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Set<DishProduct> getByProduct(Product product) {
        Query query = entityManager.createQuery("SELECT dp FROM DishProduct dp WHERE dp.product.id = " + product.getId());
        return (Set<DishProduct>) query.getResultStream().collect(Collectors.toSet());
    }
}

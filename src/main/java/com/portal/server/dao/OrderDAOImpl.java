package com.portal.server.dao;

import com.portal.server.entity.Order;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public Order getById(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> getAllOrders() {
        Query query = entityManager.createQuery("SELECT o FROM Order o");
        List<Order> orders = (List<Order>)query.getResultList();
        return orders;
    }
}

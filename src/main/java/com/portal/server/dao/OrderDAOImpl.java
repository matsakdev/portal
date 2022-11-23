package com.portal.server.dao;

import com.portal.server.entity.Order;
import com.portal.server.entity.OrderProduct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Component
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    @Transactional
    public Order getById(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        Query query = entityManager.createQuery("SELECT o FROM Order o");
        List<Order> orders = (List<Order>)query.getResultList();
        return orders;
    }

    @Override
    @Transactional
    public void save(Set<OrderProduct> orderProducts) {
//        orderProducts.forEach(pair -> entityManager.persist(pair));
//        entityManager.persist(orderProducts);
        orderProducts.forEach(this::save);
    }


    public void save(OrderProduct orderProduct) {
        entityManager.persist(orderProduct);
    }
}

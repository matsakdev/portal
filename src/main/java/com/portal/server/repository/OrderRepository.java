package com.portal.server.repository;

import com.portal.server.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {
    void save(Order order);
    Order getById(Long id);

    List<Order> getAllOrders();
}

package com.portal.server.dao;

import com.portal.server.entity.Order;

import java.util.List;

public interface OrderDAO {
    void save(Order order);
    Order getById(Long id);

    List<Order> getAllOrders();
}

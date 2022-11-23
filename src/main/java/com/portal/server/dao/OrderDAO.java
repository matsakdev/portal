package com.portal.server.dao;

import com.portal.server.entity.Order;
import com.portal.server.entity.OrderProduct;

import java.util.List;
import java.util.Set;

public interface OrderDAO {
    void save(Order order);
    Order getById(Long id);

    List<Order> getAllOrders();

    void save(Set<OrderProduct> orderProducts);
}

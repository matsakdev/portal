package com.portal.server.repository;

import com.portal.server.entity.Order;
import com.portal.server.entity.OrderProduct;
import com.portal.server.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface OrderRepository {
    void save(Order order);
    void save(Set<OrderProduct> orderProducts);
    Order getById(Long id);

    List<Order> getAllOrders();

    void save(Long customerId, Order orderDetails, Map<Long, Long> products);
}


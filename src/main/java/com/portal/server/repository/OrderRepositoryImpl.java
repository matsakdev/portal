package com.portal.server.repository;

import com.portal.server.dao.OrderDAO;
import com.portal.server.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    OrderDAO orderDAO;

    @Override
    public void save(Order order) {
        orderDAO.save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderDAO.getById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}

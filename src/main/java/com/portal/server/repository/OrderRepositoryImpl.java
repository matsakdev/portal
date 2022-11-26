package com.portal.server.repository;

import com.portal.server.dao.OrderDAO;
import com.portal.server.dao.ProductDAO;
import com.portal.server.entity.Order;
import com.portal.server.entity.OrderProduct;
import com.portal.server.entity.Product;
import com.portal.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductDAO productDAO;

    @Override
    public void save(Order order) {
        orderDAO.save(order);
    }

    @Override
    public void save(Set<OrderProduct> orderProducts) {
        orderProducts.forEach(orderDAO::save);
    }

    @Override
    public Order getById(Long id) {
        return orderDAO.getById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public void save(Long customerId, Order orderDetails, Map<Long, Long> products) {
        User user = userRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Not found such user in DB"));
        orderDetails.setCustomer(user);
        save(orderDetails);
        Set<OrderProduct> orderProducts = attachOrderWithProducts(orderDetails, products);
        orderProducts.forEach(this::save);
//        orderDetails.setProducts(orderProducts);
//        save(orderDetails);
    }

    @Override
    public void update(Order order) {
        orderDAO.save(order);
    }

    private void save(OrderProduct orderProduct) {
        orderDAO.save(orderProduct);
    }

    private Set<OrderProduct> attachOrderWithProducts(Order orderDetails, Map<Long, Long> products) {
        Set<OrderProduct> orderProducts = new HashSet<>();
        products.forEach((productId, amount) -> {
            orderProducts.add(new OrderProduct(amount, orderDetails,
                    Optional.of(productDAO
                            .getById(productId))
                            .orElseThrow(() -> new IllegalArgumentException("This product doesn't exist in DB"))));
        });
        return orderProducts;
    }
}

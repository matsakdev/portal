package com.portal.server.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.portal.server.dto.OrderDto;
import com.portal.server.entity.Order;
import com.portal.server.entity.Product;
import com.portal.server.payload.order.RequestAddOrder;
import com.portal.server.repository.OrderRepository;
import com.portal.server.repository.OrderRepositoryImpl;
import com.portal.server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public Order addOrder(@RequestBody RequestAddOrder requestAddOrder) {
        orderRepository.save(requestAddOrder.getCustomerId(), requestAddOrder.getOrderDetails(), requestAddOrder.getProducts());
        return requestAddOrder.getOrderDetails();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderRepository.getById(id);
        return order == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(order);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        if (!order.getId().equals(id)) return ResponseEntity.badRequest().build();
        orderRepository.update(order);
        return ResponseEntity.ok(order);
    }

    @GetMapping()
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.of(Optional.of(orderRepository.getAllOrders()));
    }

    @DeleteMapping
    @PreAuthorize("hasRole('MANAGER')")
    public Product deleteOrder(Product product) {
        return product;
    }
}

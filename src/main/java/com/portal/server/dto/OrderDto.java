package com.portal.server.dto;

import com.portal.server.entity.Address;
import com.portal.server.entity.Order;
import com.portal.server.entity.OrderProduct;
import com.portal.server.entity.OrderStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OrderDto {

    private Long id;
    private Long customerId;
    private OrderStatus status;
    private String userNote;
    private String moderatorNote;
    private Address address;
    private Map<Long, Long> products;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.customerId = order.getCustomer().getId();
        this.status = order.getStatus();
        this.userNote = order.getUserNote();
        this.moderatorNote = order.getModeratorNote();
        this.address = order.getAddress();
        this.products = getProductsFromOrder(order.getProducts());
    }

    private Map<Long, Long> getProductsFromOrder(Set<OrderProduct> products) {
        Map<Long, Long> productsAndCount = new HashMap<>();
        products.forEach(product -> {
            productsAndCount.put(product.getProduct().getId(), product.getAmount());
        });
        return productsAndCount;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Map<Long, Long> getProducts() {
        return products;
    }

    public void setProducts(Map<Long, Long> products) {
        this.products = products;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    public String getModeratorNote() {
        return moderatorNote;
    }

    public void setModeratorNote(String moderatorNote) {
        this.moderatorNote = moderatorNote;
    }
}

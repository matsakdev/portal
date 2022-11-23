package com.portal.server.payload.order;

import com.portal.server.entity.Order;
import com.portal.server.entity.Product;

import java.util.Map;

public class RequestAddOrder {
    private Order orderDetails;
    private Long customerId;
    private Map<Long, Long> products;

    public RequestAddOrder(Order order, Long customerId, Map<Long, Long> products) {
        this.orderDetails = order;
        this.customerId = customerId;
        this.products = products;
    }

    public Order getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Order order) {
        this.orderDetails = order;
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
}

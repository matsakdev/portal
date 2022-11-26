package com.portal.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_products")
public class OrderProduct {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "ORDER_ID")
        protected Long orderId;

        @Column(name = "PRODUCT_ID")
        protected Long productId;

        public Id(){}

        public Id(Long orderId, Long productId) {
            this.orderId = orderId;
            this.productId = productId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;
            Id id = (Id) o;
            return Objects.equals(orderId, id.orderId) && Objects.equals(productId, id.productId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderId, productId);
        }
    }

    @EmbeddedId
    Id id = new Id();

    @Column(name = "AMOUNT")
    @NotNull
    private Long amount;

    @ManyToOne
    @JoinColumn(
            name = "ORDER_ID",
            insertable = false, updatable = false)
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(
            name = "PRODUCT_ID",
            insertable = false, updatable = false)
    private Product product;

    public OrderProduct(Long amount, Order order, Product product) {
        this.amount = amount;
        this.order = order;
        this.product = product;

        this.id.orderId = order.getId();
        this.id.productId = product.getId();
    }

    public OrderProduct() {
    }

    public Id getId() {
        return id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

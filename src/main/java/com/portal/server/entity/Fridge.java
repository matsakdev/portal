package com.portal.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "fridge")
public class Fridge {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name="USER_ID")
        protected Long userId;
        @Column(name="PRODUCT_ID")
        protected Long productId;
        public Id(){}

        public Id(Long userId, Long productId) {
            this.userId = userId;
            this.productId = productId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;
            Id id = (Id) o;
            return Objects.equals(userId, id.userId) && Objects.equals(productId, id.productId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, productId);
        }
    }

    @EmbeddedId
    @JsonIgnore
    private Id id = new Id();

    @ManyToOne
    @JoinColumn(
            name = "USER_ID",
            insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "PRODUCT_ID",
            insertable = false, updatable = false)
    private Product product;

    @Column(name = "AMOUNT")
    private Long amount;

    public Fridge() {
    }

    public Fridge(User user, Product product, Long productAmount) {
        this.user = user;
        this.product = product;
        this.amount = productAmount;

        this.id.userId = user.getId();
        this.id.productId = product.getId();
    }
    public Fridge(User user, Product product) {
        this.user = user;
        this.product = product;

        this.id.userId = user.getId();
        this.id.productId = product.getId();
    }

    public Id getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}

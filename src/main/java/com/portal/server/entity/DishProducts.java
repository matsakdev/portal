package com.portal.server.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="dish_products")
@org.hibernate.annotations.Immutable
public class DishProducts {

    @Embeddable
    public static class Id implements Serializable {

        @Column(name="DISH_ID")
        protected Long dishId;

        @Column(name="PRODUCT_ID")
        protected Long productId;

        public Id(){
        }

        public Id(Long dishId, Long productId) {
            this.dishId = dishId;
            this.productId = productId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return Objects.equals(dishId, id.dishId) && Objects.equals(productId, id.productId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dishId, productId);
        }
    }

    @EmbeddedId
    Id id = new Id();

    @Column(name="AMOUNT")
    @NotNull
    protected Long amount;

    @ManyToOne
    @JoinColumn(
            name="DISH_ID",
            insertable = false, updatable = false)
    protected Dish dish;

    @ManyToOne
    @JoinColumn(
            name="PRODUCT_ID",
            insertable = false, updatable = false
    )
    protected Product product;

    public DishProducts(){}

    public DishProducts(
            Long amount,
            Dish dish, Product product) {
        this.amount = amount;
        this.dish = dish;
        this.product = product;

        this.id.dishId = dish.getId();
        this.id.productId = product.getId();

        dish.getDishProducts().add(this);
        product.getDishProducts().add(this);
    }

}

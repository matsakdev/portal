package com.portal.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Recipe {
    @Embeddable
    public static class Id implements Serializable{
        @Column(name="DISH_ID")
        protected Long dishId;

        @Column(name="STEP")
        protected Long step;

        public Id(){
        }

        public Id(Long dishId, Long step) {
            this.dishId = dishId;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return Objects.equals(dishId, id.dishId) && Objects.equals(step, id.step);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dishId, step);
        }
    }

    @EmbeddedId
    Id id = new Id();

    @Column(name="DESCRIPTION")
    @NotNull
    protected String description;

    @ManyToOne
    @JoinColumn(
            name="DISH_ID",
            insertable = false, updatable = false)
    @JsonIgnore
    protected Dish dish;

    public Long getStep() {
        return id.step;
    }

    public void setStep(Long step) {
        this.id.step = step;
    }

    public Recipe(){
    }

    public Recipe(
            Dish dish,
            Long step, String description) {
        this.dish = dish;
        this.description = description;

        this.id.dishId = dish.getId();
        this.id.step = step;

        dish.getInstructions().add(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}

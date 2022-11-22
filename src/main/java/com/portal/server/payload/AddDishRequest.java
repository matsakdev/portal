package com.portal.server.payload;

import com.portal.server.entity.Dish;
import com.portal.server.entity.Recipe;

import java.util.Map;
import java.util.Set;

public class AddDishRequest {
    private Dish dish;
    private Set<Recipe> instructions;
    private Map<Long, Long> products;
    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Set<Recipe> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<Recipe> instructions) {
        this.instructions = instructions;
    }

    public Map<Long, Long> getProducts() {
        return products;
    }

    public void setProducts(Map<Long, Long> products) {
        this.products = products;
    }

    public AddDishRequest() {
    }

    public AddDishRequest(Dish dish, Set<Recipe> instructions, Map<Long, Long> products, Long categoryId) {
        this.dish = dish;
        this.instructions = instructions;
        this.products = products;
        this.categoryId = categoryId;
    }
}

package com.portal.server.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Dish {


    @Id
    @Column(name="DISH_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="NAME")
    protected String name;

    @Column(name="PHOTO_URL")
    protected String photo;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    protected DishCategory category;

    @Column(name="CALORICITY")
    private Double caloricity;
    @OneToMany(mappedBy="dish")
    protected Set<DishProducts> dishProducts = new HashSet<>();

    @OneToMany(mappedBy = "dish")
    protected Set<Recipe> instructions = new HashSet<>();

    public Dish(){}

    public Dish(String name, String photo, DishCategory category, Double caloricity, Set<DishProducts> dishProducts, Set<Recipe> instructions) {
        this.name = name;
        this.photo = photo;
        this.category = category;
        this.caloricity = caloricity;
        this.dishProducts = dishProducts;
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<DishProducts> getDishProducts() {
        return dishProducts;
    }

    public void setDishProducts(Set<DishProducts> dishProducts) {
        this.dishProducts = dishProducts;
    }

    public Set<Recipe> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<Recipe> instructions) {
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(id, dish.id) && Objects.equals(name, dish.name) && Objects.equals(photo, dish.photo) && Objects.equals(dishProducts, dish.dishProducts) && Objects.equals(instructions, dish.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, photo, dishProducts, instructions);
    }

}

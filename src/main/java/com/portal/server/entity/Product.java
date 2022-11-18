package com.portal.server.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @Column(name="PRODUCT_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;

    @Column(name="NAME")
    protected String name;

    @Column(name="PHOTO_URL")
    protected String photo;

    @OneToMany(mappedBy="product")
    protected Set<DishProducts> dishProducts = new HashSet<>();

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
}

package com.portal.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @Column(name="PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name="NAME", nullable = false)
    protected String name;

    @Column(name="PHOTO_URL", nullable = false)
    protected String photo;

    @Column(name="PRICE")
    protected Double price;

    @OneToOne
    @JoinColumn(name = "PRODUCT_CATEGORY_ID")
    protected ProductCategory category;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    Set<OrderProduct> orders;

    @Column(name="CAPACITY")
    protected Double capacity;

    public Product(){}

    public Product(String name, String photo, Double price, ProductCategory category) {
        this.name = name;
        this.photo = photo;
        this.category = category;
        this.price = price;
    }

    public Product(String name, String photo, Double price, ProductCategory category, Set<OrderProduct> orders, Double capacity) {
        this.name = name;
        this.photo = photo;
        this.price = price;
        this.category = category;
        this.orders = orders;
        this.capacity = capacity;
    }

    public Product(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory productCategory) {
        this.category = productCategory;
    }

    //    @OneToMany(mappedBy="product")
//    protected Set<DishProduct> dishProducts = new HashSet<>();

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<OrderProduct> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderProduct> orders) {
        this.orders = orders;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        return photo != null ? photo.equals(product.photo) : product.photo == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }

}

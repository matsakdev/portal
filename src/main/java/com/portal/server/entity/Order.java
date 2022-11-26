package com.portal.server.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "USER_NOTE")
    private String userNote;

    @Column(name = "MODERATOR_NOTE")
    private String moderatorNote;

    private Address address;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User customer;

    @OneToMany(mappedBy = "order")
    private Set<OrderProduct> products;

    public Order(User customer, Set<OrderProduct> products, String userNote, String moderatorNote, Address address, OrderStatus status) {
        this.customer = customer;
        this.products = products;
        this.userNote = userNote;
        this.moderatorNote = moderatorNote;
        this.address = address;
        this.status = status;
    }

    public Order(String userNote, String moderatorNote, Address address, OrderStatus status) {
        this.userNote = userNote;
        this.moderatorNote = moderatorNote;
        this.address = address;
        this.status = status;
    }

    public Order(){}

    public Long getId() {
        return id;
    }


    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Set<OrderProduct> getProducts() {
        return products;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setProducts(Set<OrderProduct> products) {
        this.products = products;
    }
}

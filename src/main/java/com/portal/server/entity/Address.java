package com.portal.server.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE")
    private String house;

    @Column(name = "APARTMENT")
    private String apartment;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Address() {
    }

    public Address(String city, String street, String house, String apartment) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }
}

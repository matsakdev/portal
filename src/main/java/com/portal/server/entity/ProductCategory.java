package com.portal.server.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_CATEGORY_ID")
    protected Long id;

    @Column(name = "TITLE")
    protected String title;

    @Column(name = "PHOTO_URL")
    protected String photo;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

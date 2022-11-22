package com.portal.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "dish_category")
public class DishCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="TITLE", unique = true, nullable = false)
    private String title;

    @Column(name="PHOTO_URL", nullable = false)
    private String photo;

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

    public DishCategory(){}

    public DishCategory(String title, String photo) {
        this.title = title;
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishCategory)) return false;

        DishCategory category = (DishCategory) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        return title != null ? title.equals(category.title) : category.title == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}

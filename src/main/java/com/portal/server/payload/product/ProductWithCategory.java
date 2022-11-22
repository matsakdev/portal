package com.portal.server.payload.product;

import com.portal.server.entity.Product;

public class ProductWithCategory {
    private Product product;
    private Long categoryId;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public ProductWithCategory(Product product, Long categoryId) {
        this.product = product;
        this.categoryId = categoryId;
    }

    public ProductWithCategory(){}
}

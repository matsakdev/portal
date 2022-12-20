package com.portal.server.payload;

public class ProductRequest {
    Long productid;

    public ProductRequest() {
    }

    public ProductRequest(Long productid) {
        this.productid = productid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }
}

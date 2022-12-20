package com.portal.server.repository;

import com.portal.server.entity.Product;

import java.util.Set;

public interface FridgeRepository {
    Set<Product> getProductsFromUserFridge(Long userId);
    void addProductToFridge(Long userId, Long productId, Long productAmount);
    void deleteProductFromFridge(Long userid, Long productId, Long productAmount);
}

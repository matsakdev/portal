package com.portal.server.dao;

import com.portal.server.entity.Dish;
import com.portal.server.entity.DishProduct;
import com.portal.server.entity.Product;

import java.util.Set;

public interface DishProductsDAO {
    void save(DishProduct dishProduct);
    Set<DishProduct> getByDish(Dish dish);
    Set<DishProduct> getByProduct(Product product);

}

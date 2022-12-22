package com.portal.server.repository;

import com.portal.server.entity.Dish;
import com.portal.server.entity.DishProduct;
import com.portal.server.entity.Recipe;

import java.util.Optional;
import java.util.Set;


public interface DishRepository {

    void createDish(Dish dish);
    Optional<Dish> findById(Long id);
    boolean dishExists(Long id);
    boolean deleteDishAndReturnResult(Long id);
    void updateDish(Dish dish);

    void createDish(Dish dish, Long categoryId, Set<Recipe> instructions, Set<DishProduct> dishProducts);

    Set<Dish> findAll();

    Set<Dish> getAllByCategory(Long categoryId);

    boolean matchRestrictions(Dish dish, Long userId);
}

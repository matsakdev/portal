package com.portal.server.repository;

import com.portal.server.entity.Dish;

import java.util.Optional;

public interface DishRepository {

    void createDish(Dish dish);
    Optional<Dish> findById(Long id);
    boolean dishExists(Long id);
    boolean deleteDishAndReturnResult(Long id);
    void updateDish(Dish dish);
}

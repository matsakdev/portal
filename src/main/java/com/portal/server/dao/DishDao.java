package com.portal.server.dao;

import com.portal.server.entity.Dish;
import com.portal.server.entity.DishCategory;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

public interface DishDao {
    void saveDish(Dish dish);
    Optional<Dish> getById(Long id);
    Set<Dish> getAllDishes();
    void deleteDish(Long id);

    void update(Dish dish);
}

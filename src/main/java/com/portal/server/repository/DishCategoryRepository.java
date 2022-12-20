package com.portal.server.repository;

import com.portal.server.entity.Dish;
import com.portal.server.entity.DishCategory;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DishCategoryRepository {
    void save(DishCategory dishCategory);
    DishCategory getById(Long id);
    Set<DishCategory> getAllCategories();
}

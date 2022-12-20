package com.portal.server.dao;

import com.portal.server.entity.Dish;
import com.portal.server.entity.DishCategory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface DishCategoryDAO {
    void saveCategory(DishCategory dishCategory);

    DishCategory getCategoryById(Long id);

    Set<DishCategory> getAllCategories();
}

package com.portal.server.dao;

import com.portal.server.entity.DishCategory;
import org.springframework.stereotype.Component;

@Component
public interface DishCategoryDAO {
    void saveCategory(DishCategory dishCategory);

    DishCategory getCategoryById(Long id);


}

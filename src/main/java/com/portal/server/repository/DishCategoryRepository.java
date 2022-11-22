package com.portal.server.repository;

import com.portal.server.entity.DishCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface DishCategoryRepository {
    void save(DishCategory dishCategory);
    DishCategory getById(Long id);
}

package com.portal.server.repository;

import com.portal.server.dao.DishCategoryDAO;
import com.portal.server.entity.Dish;
import com.portal.server.entity.DishCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class DishCategoryRepositoryImpl implements DishCategoryRepository {

    @Autowired
    DishCategoryDAO dishCategoryDAO;

    @Override
    public void save(DishCategory dishCategory) {
        dishCategoryDAO.saveCategory(dishCategory);
    }


    @Override
    public DishCategory getById(Long id) {
        return dishCategoryDAO.getCategoryById(id);
    }

    @Override
    public Set<DishCategory> getAllCategories() {
        return dishCategoryDAO.getAllCategories();
    }
}

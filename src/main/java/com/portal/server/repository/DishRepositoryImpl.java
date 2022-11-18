package com.portal.server.repository;

import com.portal.server.dao.DishDao;
import com.portal.server.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DishRepositoryImpl implements DishRepository {

    private DishDao dishDAO;

    @Autowired
    private DishRepositoryImpl(DishDao dishDAO){
        this.dishDAO = dishDAO;
    }

    @Override
    public void createDish(Dish dish) {

    }

    @Override
    public Optional<Dish> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean dishExists(Long id) {
        return dishDAO.getById(id).isPresent();
    }

    @Override
    public boolean deleteDishAndReturnResult(Long id) {
        return false;
    }

    @Override
    public void updateDish(Dish dish) {
        dishDAO.update(dish);
    }
}

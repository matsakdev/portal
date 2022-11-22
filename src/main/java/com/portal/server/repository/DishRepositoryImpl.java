package com.portal.server.repository;

import com.portal.server.dao.DishCategoryDAO;
import com.portal.server.dao.DishDao;
import com.portal.server.entity.Dish;
import com.portal.server.entity.DishProduct;
import com.portal.server.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class DishRepositoryImpl implements DishRepository {

    @Autowired
    private DishDao dishDAO;

    @Autowired
    DishCategoryDAO dishCategoryDAO;

    @Autowired
    private DishRepositoryImpl(DishDao dishDAO){
        this.dishDAO = dishDAO;
    }

    @Override
    public void createDish(Dish dish) {
        dishDAO.saveDish(dish);
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

    @Override
    public void createDish(Dish dish, Long categoryId, Set<Recipe> instructions, Set<DishProduct> dishProducts) {
        dish.setCategory(dishCategoryDAO.getCategoryById(categoryId));
        dish.setDishProducts(dishProducts);
        dish.setInstructions(instructions);
        createDish(dish);
    }
}

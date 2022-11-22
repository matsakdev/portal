package com.portal.server.dao;

import com.portal.server.entity.DishCategory;
import com.portal.server.entity.Recipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

public class RecipeDAOImpl implements RecipeDAO {

    Logger logger = LogManager.getLogger(RecipeDAOImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveRecipe(Recipe recipe) {
        entityManager.persist(recipe);
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return entityManager.find(Recipe.class, id);
    }
}

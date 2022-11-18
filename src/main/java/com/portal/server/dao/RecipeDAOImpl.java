package com.portal.server.dao;

import com.portal.server.entity.DishCategory;
import com.portal.server.entity.Recipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;

public class RecipeDAOImpl implements RecipeDAO {

    Logger logger = LogManager.getLogger(RecipeDAOImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveRecipe(Recipe recipe) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.save(recipe);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            logger.info(e.getMessage());
            throw e;
        }
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            Recipe recipe = session.get(Recipe.class, id);
            session.getTransaction().commit();
            return recipe;
        } catch (PersistenceException e) {
            logger.info(e.getMessage());
            throw e;
        }
    }
}

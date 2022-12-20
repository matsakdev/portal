package com.portal.server.dao;

import com.portal.server.entity.Dish;
import com.portal.server.entity.DishCategory;
import com.portal.server.error.DuplicateEntryException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Component
public class DishCategoryDAOImpl implements DishCategoryDAO {

    private final Logger logger = LogManager.getLogger(DishCategoryDAOImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void saveCategory(DishCategory dishCategory) {
        try {
            entityManager.persist(dishCategory);
        } catch (PersistenceException error) {
            processException(error, dishCategory);
        }
    }
    @Transactional
    @Override
    public DishCategory getCategoryById(Long id) {
        DishCategory category = entityManager.find(DishCategory.class, id);
        return category;
    }

    @Override
    public Set<DishCategory> getAllCategories() {
        return Set.copyOf(entityManager.createQuery("SELECT category FROM DishCategory category").getResultList());
    }

    private void processException(PersistenceException error, DishCategory dishCategory) {
        if (error.getCause().getClass().equals(org.hibernate.exception.ConstraintViolationException.class)) {
            throw new DuplicateEntryException("The same category has been already exists @title: " + dishCategory.getTitle(), error);
        }
    }
}

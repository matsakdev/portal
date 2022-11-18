package com.portal.server.dao;

import com.portal.server.entity.Dish;
import com.portal.server.entity.DishCategory;
import com.portal.server.error.DuplicateEntryException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;

public class DishCategoryDAOImpl implements DishCategoryDAO {

    private final Logger logger = LogManager.getLogger(DishCategoryDAOImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveCategory(DishCategory dishCategory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.save(dishCategory);
            session.getTransaction().commit();
        } catch (PersistenceException error) {
            processException(error, dishCategory);
        }
    }

    @Override
    public DishCategory getCategoryById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        DishCategory category = session.get(DishCategory.class, id);
        session.getTransaction().commit();
        return category;
    }

    private void processException(PersistenceException error, DishCategory dishCategory) {
        if (error.getCause().getClass().equals(org.hibernate.exception.ConstraintViolationException.class)) {
            throw new DuplicateEntryException("The same category has been already exists @title: " + dishCategory.getTitle(), error);
        }
    }
}

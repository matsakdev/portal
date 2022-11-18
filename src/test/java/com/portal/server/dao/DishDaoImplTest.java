package com.portal.server.dao;

import com.portal.server.config.EntityManagerConfig;
import com.portal.server.entity.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {DishDaoImpl.class, EntityManagerConfig.class, DishProducts.class, Product.class})
class DishDaoImplTest {

    @Autowired
    DishDao dishDao;

    @Autowired
    DishCategoryDAO dishCategoryDAO;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    void saveDish() {
//        DishCategory category = new DishCategory("FIRST");
//        dishCategoryDAO
//        Dish dish = new Dish("dish1", "photo1", category)
//        dishDao.saveDish(dish);
//
//        Long dishId = dish.getId();
//        System.out.println(dishId);
//
//        assertNotNull(dishId);
//
//        Dish savedDish = dishDao.getById(dishId).get();
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        assertEquals(dish, savedDish);
//
//        session.getTransaction().commit();
//        session.close();

    }

    @Test
    void getById() {
    }

    @Test
    void getAllDishes() {

    }

    @Test
    void deleteDish() {
    }
}
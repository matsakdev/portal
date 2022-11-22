package com.portal.server.dao;

import com.portal.server.ServerApplication;
import com.portal.server.config.EntityManagerConfig;
import com.portal.server.entity.DishCategory;
import com.portal.server.error.DuplicateEntryException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {ServerApplication.class, DishCategoryDAOImpl.class, DishCategory.class, EntityManagerConfig.class, EntityManager.class, EntityManagerFactory.class, org.hibernate.jpa.HibernatePersistenceProvider.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DishCategoryDAOImplTest {

    private static Logger logger = LogManager.getLogger(DishCategoryDAOImplTest.class);
    @Autowired
    DishCategoryDAO dishCategoryDAO;

    private static DishCategory dishCategory;

    @BeforeAll
    static void beginTest() {
        logger.info("TEST HAS BEEN STARTED: " + DishCategoryDAOImplTest.class);
    }

    @AfterAll
    static void endTest() {
        logger.info("TEST IS OVER");
    }

    @BeforeEach
    void initializeTest() {
        dishCategory = new DishCategory("TEST_SOUPS");
    }

    @AfterEach
    void clearDB() {
//        entityManager.getTransaction().begin();
//        entityManager.createQuery("DELETE FROM DishCategory dc WHERE dc.title='TEST_SOUPS'").executeUpdate();
//        entityManager.getTransaction().commit();
    }

    @Test
    void saveCategoryTest() {
        dishCategoryDAO.saveCategory(dishCategory);

        assertNotNull(dishCategory.getId());

        assertEquals(dishCategory, dishCategoryDAO.getCategoryById(dishCategory.getId()));
    }

    @Test
    void titlesMustBeUniqueTest() {
        assertThrows(DuplicateEntryException.class, () -> {
            dishCategoryDAO.saveCategory(dishCategory);

            dishCategoryDAO.saveCategory(dishCategory);
        });
    }



    @Test
    void getCategoryById() {

        dishCategoryDAO.saveCategory(dishCategory);

        DishCategory categoryFromDB = dishCategoryDAO.getCategoryById(dishCategory.getId());

        assertEquals(dishCategory, categoryFromDB);
    }
}
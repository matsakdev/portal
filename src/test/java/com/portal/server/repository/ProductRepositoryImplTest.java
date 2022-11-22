package com.portal.server.repository;

import com.portal.server.DBConfig;
import com.portal.server.ServerApplication;
import com.portal.server.config.EntityManagerConfig;
import com.portal.server.dao.ProductDAO;
import com.portal.server.dao.ProductDAOImpl;
import com.portal.server.entity.DishCategory;
import com.portal.server.entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@SpringBootTest
//@SpringBootTest(classes = {ProductRepository.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryImplTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ProductRepository productRepository;

    private Product product;

    private static void initialize() {
//        Properties p = new Properties();
//        p.put(Context.INITIAL_CONTEXT_FACTORY,"org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean");

//        p.put("movie-unit.hibernate.hbm2ddl.auto", "update");
//        p.put("movie-unit.hibernate.dialect", "org.hibernate.dialect.HSQLDialect");

//        InitialContext context = new InitialContext(p);
    }

    @BeforeEach
    void initializeTest() {
        product = new Product();
        product.setName("TEST_PRODUCT");
        product.setPhoto("TEST_PHOTO");
    }

    @AfterEach
    @Transactional
    void clearDB() {
        entityManager.remove(product);
    }

    @Test
    void addProduct() {
        productRepository.addProduct(product);

        assertNotNull(product.getId());
    }

    @Test
    void getById() {
        productRepository.addProduct(product);

        assertEquals(product, productRepository.getById(product.getId()));
    }
}
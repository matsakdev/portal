package com.portal.server.config;

import com.portal.server.config.AppProperties;
import com.portal.server.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

@org.springframework.context.annotation.Configuration
public class EntityManagerConfig {

//    @Autowired
//    private static EntityManagerFactory entityManagerFactory;
//
//    @Bean
//    public static EntityManagerFactory getEntityManagerFactory(){
//        return Persistence.createEntityManagerFactory("PortalMySqlUnit");
//    }
//
//    @Bean
//    public static EntityManager getEntityManager(){
//        return entityManagerFactory.createEntityManager();
//    }

    @Bean
    public static SessionFactory getSessionFactory(){
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dish.class)
                .addAnnotatedClass(DishProducts.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Recipe.class)
                .addAnnotatedClass(ProductCategory.class)
                .addAnnotatedClass(DishCategory.class)
                .addAnnotatedClass(Fridge.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();
    }






}

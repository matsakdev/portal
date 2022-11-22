package com.portal.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class DBConfig {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySqlEntityManager");

    @Bean
    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}

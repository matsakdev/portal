package com.portal.server;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ServerApplication {

    @Autowired
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

            SpringApplication.run(ServerApplication.class, args);

//        finally {
//            sessionFactory.close();
//        }
    }

}

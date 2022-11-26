package com.portal.server.dao;

import com.portal.server.entity.Dish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DishDaoImpl implements DishDao {

    private Logger logger = LogManager.getLogger(DishDaoImpl.class);

    @Autowired
    EntityManager entityManager;

    @Override
    public void saveDish(Dish dish) {
        entityManager.persist(dish);
    }

    @Override
    public Optional<Dish> getById(Long id) {
        return Optional.of(entityManager.find(Dish.class, id));
    }

    @Override
    public Set<Dish> getAllDishes() {
        Query query = entityManager.createQuery("SELECT dish FROM Dish dish");
        return (Set<Dish>) query.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public void deleteDish(Long id) {
        entityManager.remove(entityManager.find(Dish.class, id));
    }

    @Override
    public void update(Dish dish) {
        entityManager.persist(dish);
        logger.debug("Dish @id: " + dish.getId() + " was updated. " + dish);
    }

//    private <T, R> R processTransaction(T input, DaoProcessor<Session, T, R> function) {
//        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        R result = function.apply(session, input);
//        session.getTransaction().commit();
//        return result;
//    }
//
//    private <R> Set<R> processTransaction(Function<Session, Set<R>> getFunction) {
//        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Set<R> resultSet = getFunction.apply(session);
//        session.getTransaction().commit();
//        return resultSet;
//    }
}
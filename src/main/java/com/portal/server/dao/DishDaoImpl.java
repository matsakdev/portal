package com.portal.server.dao;

import com.portal.server.entity.Dish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DishDaoImpl implements DishDao {

    private Logger logger = LogManager.getLogger(DishDaoImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveDish(Dish dish) {
        processTransaction(dish,
                (session, inputValue) -> session.save(dish));
    }

    @Override
    public Optional<Dish> getById(Long id) {
        Dish dish = processTransaction(
                id,
                (session, inputValue) -> session.get(Dish.class, inputValue));
        return Optional.of(dish);
    }

    @Override
    public Set<Dish> getAllDishes() {
//        Set<Dish> allDishes = processTransaction(session -> session.get(Dish.class));
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Set<Dish> allDishes = session
                .createQuery("SELECT a FROM Dish a", Dish.class)
                .getResultStream()
                .collect(Collectors.toSet());
        session.getTransaction().commit();
        return allDishes;
    }

    @Override
    public void deleteDish(Long id) {
        Dish deletedDish = processTransaction(id,
                (session, inputId) -> {
                    Dish dishToDelete = session.get(Dish.class, inputId);
                    session.delete(dishToDelete);
                    return dishToDelete;
                });
        logger.debug("Dish @id: " + id + "; " + deletedDish + " was deleted");
    }

    @Override
    public void update(Dish dish) {
        Dish updatedDish = processTransaction(dish,
                (session, inputValue) -> {
                    session.update(dish);
                    return dish;
                });
        logger.debug("Dish @id: " + updatedDish.getId() + " was updated. " + dish);
    }

    private <T, R> R processTransaction(T input, DaoProcessor<Session, T, R> function) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        R result = function.apply(session, input);
        session.getTransaction().commit();
        return result;
    }

    private <R> Set<R> processTransaction(Function<Session, Set<R>> getFunction) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Set<R> resultSet = getFunction.apply(session);
        session.getTransaction().commit();
        return resultSet;
    }
}

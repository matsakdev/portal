package com.portal.server.dao;

import com.portal.server.entity.Restriction;
import com.portal.server.entity.User;
import com.portal.server.entity.UserRestrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Component
public class RestrictionDAOImpl implements RestrictionDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Set<Restriction> getAllRestrictions() {
        return Set.copyOf(entityManager.createQuery("SELECT restr FROM Restriction restr").getResultList());
    }

    @Override
    @Transactional
    public void addNewRestriction(Long userId, Long restrictionId) {
        User user = entityManager.find(User.class, userId);
        Restriction restriction = entityManager.find(Restriction.class, restrictionId);
        System.out.println(user + "\n" + restriction);
        entityManager.persist(new UserRestrictions(user, restriction));
    }

    @Override
    @Transactional
    public void deleteRestriction(Long userId, Long restrictionId) {
        UserRestrictions userRestrictions = entityManager.find(UserRestrictions.class, new UserRestrictions.Id(userId, restrictionId));
        entityManager.remove(userRestrictions);
    }

    @Override
    @Transactional
    public Set<Restriction> getAllUserRestrictions(Long userId) {
        return Set.copyOf(entityManager
                .createQuery("SELECT rest FROM Restriction rest" +
                        " JOIN FETCH UserRestrictions ur ON ur.restriction=rest" +
                        " WHERE ur.user.id=" + userId)
                .getResultList());
    }
}

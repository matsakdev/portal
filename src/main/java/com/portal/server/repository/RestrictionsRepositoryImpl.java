package com.portal.server.repository;

import com.portal.server.dao.RestrictionDAO;
import com.portal.server.entity.Restriction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RestrictionsRepositoryImpl implements RestrictionsRepository {

    @Autowired
    RestrictionDAO restrictionDAO;

    @Override
    public Set<Restriction> getAllRestrictions() {
        return restrictionDAO.getAllRestrictions();
    }

    @Override
    public void addNewRestriction(Long userId, Long restrictionId) {
        restrictionDAO.addNewRestriction(userId, restrictionId);
    }

    @Override
    public void deleteRestriction(Long userId, Long restrictionId) {
        restrictionDAO.deleteRestriction(userId, restrictionId);
    }

    @Override
    public Set<Restriction> getAllUserRestrictions(Long userId) {
        return restrictionDAO.getAllUserRestrictions(userId);
    }
}

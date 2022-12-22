package com.portal.server.dao;

import com.portal.server.entity.Restriction;

import java.util.Set;

public interface RestrictionDAO {
    Set<Restriction> getAllRestrictions();

    void addNewRestriction(Long userId, Long restrictionId);

    void deleteRestriction(Long userId, Long restrictionId);

    Set<Restriction> getAllUserRestrictions(Long userId);
}

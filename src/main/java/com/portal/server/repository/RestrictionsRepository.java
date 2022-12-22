package com.portal.server.repository;

import com.portal.server.entity.Restriction;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface RestrictionsRepository {

    Set<Restriction> getAllRestrictions();

    void addNewRestriction(Long userId, Long restrictionId);

    void deleteRestriction(Long id, Long restrictionId);

    Set<Restriction> getAllUserRestrictions(Long userid);
}

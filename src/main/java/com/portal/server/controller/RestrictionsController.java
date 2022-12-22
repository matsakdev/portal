package com.portal.server.controller;

import com.portal.server.entity.Restriction;
import com.portal.server.payload.ApiResponse;
import com.portal.server.repository.RestrictionsRepository;
import com.portal.server.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/restrictions")
public class RestrictionsController {

    @Autowired
    RestrictionsRepository restrictionsRepository;

    @GetMapping("/all")
    public ResponseEntity<Set<Restriction>> getAllRestrictions() {
        return new ResponseEntity<>(restrictionsRepository.getAllRestrictions(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<Restriction>> getAllUserRestrictions(@AuthenticationPrincipal UserPrincipal principal) {
        return new ResponseEntity<>(restrictionsRepository.getAllUserRestrictions(principal.getId()), HttpStatus.OK);
    }

    @PutMapping("/add/{id}")
    public ResponseEntity<?> addNewRestriction(@AuthenticationPrincipal UserPrincipal principal,
                                               @PathVariable(name="id") Long restrictionId) {
        try {
            restrictionsRepository.addNewRestriction(principal.getId(), restrictionId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ApiResponse(false, "fail to add restriction"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(restrictionsRepository.getAllUserRestrictions(principal.getId()), HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteRestriction(@AuthenticationPrincipal UserPrincipal principal,
                                               @PathVariable(name="id") Long restrictionId) {
        try {
            restrictionsRepository.deleteRestriction(principal.getId(), restrictionId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ApiResponse(false, "fail to delete restriction"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(restrictionsRepository.getAllUserRestrictions(principal.getId()), HttpStatus.OK);
    }
}

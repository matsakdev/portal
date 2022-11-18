package com.portal.server.controller;

import com.portal.server.entity.Dish;
import com.portal.server.payload.ApiResponse;
import com.portal.server.repository.DishRepository;
import com.portal.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishesController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DishRepository dishRepository;

    @PostMapping("/add")
    @PreAuthorize("hasRole('MANAGER')")
    public Dish addDish(Dish dish){
        dishRepository.createDish(dish);
        return dish;
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<ApiResponse> updateDish(@PathVariable Long id, Dish dish){
        if (!dish.getId().equals(id)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {
            dishRepository.updateDish(dish);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<ApiResponse> deleteDish(@PathVariable Long id){
        if (!dishRepository.dishExists(id)) {
            return new ResponseEntity<>(new ApiResponse(Boolean.FALSE, "The dish @id: " + id + "doesn't exists"), HttpStatus.BAD_REQUEST);
        }
        if (dishRepository.deleteDishAndReturnResult(id)) {
            return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "The dish @id: " + id + "was deleted"), HttpStatus.OK);
        }
        //todo CHECK RESULT OF METHOD BY EXCEPTIONS
        else return new ResponseEntity<>(new ApiResponse(Boolean.FALSE, "Server error. The dish @id: " + id + "cannot be deleted."), HttpStatus.INTERNAL_SERVER_ERROR);
    }





}

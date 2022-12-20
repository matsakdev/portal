package com.portal.server.controller;

import com.portal.server.entity.DishCategory;
import com.portal.server.repository.DishCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories/dishes")
public class DishCategoryController {

    @Autowired
    DishCategoryRepository dishCategoryRepository;

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public void addDishCategory(@RequestBody DishCategory dishCategory) {
        dishCategoryRepository.save(dishCategory);
    }

    @GetMapping
    public ResponseEntity<?> getAllDishesCategories() {
        return ResponseEntity.ok(dishCategoryRepository.getAllCategories());
    }
}

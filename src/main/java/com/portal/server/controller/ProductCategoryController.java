package com.portal.server.controller;

import com.portal.server.entity.Dish;
import com.portal.server.entity.DishCategory;
import com.portal.server.repository.DishCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("categories/products")
public class ProductCategoryController {

    @Autowired
    DishCategoryRepository dishCategoryRepository;

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public void addDishCategory(@RequestBody DishCategory dishCategory) {
        dishCategoryRepository.save(dishCategory);
    }
}

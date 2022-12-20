package com.portal.server.controller;

import com.portal.server.entity.ProductCategory;

import com.portal.server.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories/products")
public class ProductCategoryController {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public void addProductCategory(@RequestBody ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(productCategoryRepository.getAll());
    }
}

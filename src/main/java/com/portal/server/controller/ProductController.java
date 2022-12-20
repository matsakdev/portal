package com.portal.server.controller;

import com.portal.server.entity.Dish;
import com.portal.server.entity.Product;
import com.portal.server.entity.ProductCategory;
import com.portal.server.payload.product.ProductWithCategory;
import com.portal.server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public Product addProduct(@RequestBody ProductWithCategory productWithCategory) {
        productRepository.addProduct(productWithCategory.getProduct(), productWithCategory.getCategoryId());
        return productWithCategory.getProduct();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.of(Optional.of(productRepository.getAllProducts()));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Set<Product>> getAllDishesInCategory(@PathVariable(name="id") Long categoryId) {
        Set<Product> products = productRepository.getAllByCategory(categoryId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getAllProducts(@PathVariable Long id) {
        return ResponseEntity.of(Optional.of(productRepository.getById(id)));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public Product deleteProduct(@PathVariable Long id) {
        return new Product();
    }
}

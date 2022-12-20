package com.portal.server.controller;

import com.portal.server.entity.Fridge;
import com.portal.server.entity.Product;
import com.portal.server.payload.ApiResponse;
import com.portal.server.payload.ProductRequest;
import com.portal.server.repository.FridgeRepository;
import com.portal.server.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/fridge")
public class FridgeController {
    @Autowired
    FridgeRepository fridgeRepository;

    @GetMapping
    public ResponseEntity<Set<Product>> getAllProductsFromFridge(@AuthenticationPrincipal UserPrincipal principal) {
        return new ResponseEntity<>(fridgeRepository.getProductsFromUserFridge(principal.getId()), HttpStatus.OK);
    }

    @PutMapping ("/add/{id}/amount/{count}")
    public ResponseEntity<?> addNewProductToFridge(@AuthenticationPrincipal UserPrincipal principal,
                                                   @PathVariable(name = "id") Long productId,
                                                   @PathVariable(name = "count") Long productAmount) {
        fridgeRepository.addProductToFridge(principal.getId(), productId, productAmount);
        return ResponseEntity.ok(fridgeRepository.getProductsFromUserFridge(principal.getId()));
    }

    @PutMapping("/delete/{id}/amount/{count}")
    public ResponseEntity<?> deleteProductFromFridge(@AuthenticationPrincipal UserPrincipal principal,
                                                     @PathVariable(name = "id") Long productId,
                                                     @PathVariable(name = "count") Long productAmount) {
        fridgeRepository.deleteProductFromFridge(principal.getId(), productId, productAmount);
        return ResponseEntity.ok(fridgeRepository.getProductsFromUserFridge(principal.getId()));
    }

    @PutMapping("/{id}/setamount/{amount}")
    public ResponseEntity<?> setAmountOfProductsInFridge(
            @AuthenticationPrincipal UserPrincipal principal,
            @PathVariable(name = "id") Long productId,
            @PathVariable(name = "amount") Long amount) {
        try {
            fridgeRepository.setAmountOfProduct(principal.getId(), productId, amount);
            return ResponseEntity.ok(fridgeRepository.getProductsFromUserFridge(principal.getId()));
        }
        catch (Exception e) {
            return new ResponseEntity(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}

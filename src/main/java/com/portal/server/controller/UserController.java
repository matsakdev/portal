package com.portal.server.controller;


import com.portal.server.dto.UserDTO;
import com.portal.server.entity.User;
import com.portal.server.exceptions.ResourceNotFoundException;
import com.portal.server.payload.UserByIdRequest;
import com.portal.server.repository.UserRepository;
import com.portal.server.security.Authority;
import com.portal.server.security.CurrentUser;
import com.portal.server.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("id" + id));
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PutMapping("/users/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @PathVariable(name = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new
                        IllegalArgumentException("User with @id:" + userId + " doesn't exist"));
        user.setAuthority(Authority.valueOf("ROLE_" + userDTO.getAuthority()));
        user.setName(userDTO.getFirstName());
        user.setEmail(userDTO.getEmail());
        user.setNote(userDTO.getNote());
        userRepository.save(user);
        return ResponseEntity.ok(userRepository.findById(user.getId()));
    }

    @GetMapping("/users/authorities")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<?> getAuthorities() {
        return ResponseEntity.ok(Set.of("USER", "MANAGER", "ADMIN"));
    }


}

package com.portal.server.controller;


import com.portal.server.entity.User;
import com.portal.server.exceptions.ResourceNotFoundException;
import com.portal.server.payload.UserByIdRequest;
import com.portal.server.repository.UserRepository;
import com.portal.server.security.CurrentUser;
import com.portal.server.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

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

}

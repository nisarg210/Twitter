package com.twitter.user_service.controllers;

import com.twitter.user_service.dto.UserDTO;
import com.twitter.user_service.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling user-related operations.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor injection for UserService.
     *
     * @param userService the UserService to be injected
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get user by ID.
     *
     * @param id the user ID
     * @return ResponseEntity with UserDTO
     */
    @GetMapping(path="/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }
}

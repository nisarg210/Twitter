package com.twitter.user_service.controllers;

import com.twitter.user_service.dto.UserDTO;
import com.twitter.user_service.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * Create a new user.
     *
     * @param userDTO the user data to create
     * @return ResponseEntity with the created user
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }


}

package com.educon.controller;

import com.educon.dto.UserDTO;
import com.educon.dto.UserSaveDTO;
import com.educon.dto.UserUpdateDTO;
import com.educon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to save a new user
    @PostMapping(path="/save")
    public ResponseEntity<String> saveUser(@RequestBody UserSaveDTO userSaveDTO) {
        try {
            String username = userService.addUser(userSaveDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("User " + username + " saved successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Endpoint to fetch all users
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Endpoint to update an existing user
    @PutMapping(path = "/update")
    public ResponseEntity<String> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        String username = userService.updateUser(userUpdateDTO);
        return username != null
                ? ResponseEntity.ok("User " + username + " updated successfully!")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ID not found.");
    }

    // Endpoint to delete a user by ID
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") int id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted
                ? ResponseEntity.ok("User deleted successfully!")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ID not found.");
    }
}

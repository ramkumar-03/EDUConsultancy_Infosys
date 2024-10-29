package com.educon.controller;

import com.educon.dto.UserDTO;
import com.educon.dto.UserSaveDTO;
import com.educon.dto.UserUpdateDTO;
import com.educon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String saveUser(@RequestBody UserSaveDTO userSaveDTO) {
        String username = userService.addUser(userSaveDTO);
        return "User " + username + " saved successfully!";
    }

    // Endpoint to fetch all users
    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint to update an existing user
    @PutMapping(path = "/update")
    public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        String username = userService.updateUser(userUpdateDTO);
        return "User " + username + " updated successfully!";
    }

    // Endpoint to delete a user by ID
    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? "User deleted successfully!" : "User ID not found.";
    }
}

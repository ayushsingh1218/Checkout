package com.example3.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example3.ecommerce.dto.UserDTO;
import com.example3.ecommerce.enitity.User;
import com.example3.ecommerce.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
    

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id,userDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long  id) {
         userService.deleteUser(id);
    }

    // //sign in
    // @PostMapping("/login")
    // public String loginUser(String email , String password) {
    //     return userService.loginUser(email,password);
    
    // }
    
}
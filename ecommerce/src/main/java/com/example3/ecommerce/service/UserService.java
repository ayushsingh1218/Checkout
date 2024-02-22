package com.example3.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.example3.ecommerce.dto.UserDTO;
import com.example3.ecommerce.enitity.User;

public interface UserService {

    public User createUser(UserDTO userDTO);

    public Optional<User> getUserById(Long id);

    public List<User> getAllUsers();

    public User updateUser(Long id, UserDTO userDTO);

    public void deleteUser(Long id);

    // public String loginUser(String email, String password);
    
}
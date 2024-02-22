package com.example3.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example3.ecommerce.dto.UserDTO;
import com.example3.ecommerce.enitity.User;
import com.example3.ecommerce.repository.UserRepository;
import com.example3.ecommerce.service.UserService;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityNotFoundException;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO) {
       User user = new User();
       user.setName(userDTO.getName());
       user.setMobile(userDTO.getMobile());
       user.setEmail(userDTO.getEmail());
       user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(@NonNull Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        Optional<User> optionaluser = userRepository.findById(id);
        if(optionaluser.isPresent()) {
            User user = optionaluser.get();
            user.setName(userDTO.getName());
            user.setMobile(userDTO.getMobile());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            return userRepository.save(user);
        }
        else {

            throw new EntityNotFoundException("User not found with id: " + id);
        }
      
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // @Override
    // public String loginUser(String email, String password) {
    //     Optional<User> optionaluser = userRepository.findByEmailAndPassword(email,password);
    //     if(optionaluser.isPresent()) {
            
    //     }
    // }

   
    
    
    
}
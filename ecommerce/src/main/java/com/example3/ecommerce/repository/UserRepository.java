package com.example3.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example3.ecommerce.enitity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    // Optional<User> findByEmailAndPassword(String email, String password);

    
}
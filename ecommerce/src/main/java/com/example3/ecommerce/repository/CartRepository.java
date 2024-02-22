package com.example3.ecommerce.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example3.ecommerce.enitity.Cart;
import com.example3.ecommerce.enitity.Product;
import com.example3.ecommerce.enitity.User;


@Repository
public interface CartRepository extends JpaRepository<Cart,Long>{

    Cart findByUserAndProduct(User user, Product product);
    List<Cart> findByUserId(Long userId);
    Optional<Cart> findById(Long id);
    


    
} 

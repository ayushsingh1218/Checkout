package com.example3.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.example3.ecommerce.dto.CartDTO;
import com.example3.ecommerce.enitity.Cart;

public interface CartService  {

    Cart addTocart(Long userId, Long productId, int quentity);

    List<Cart> getCartByUserId(Long userId);

    Optional<Cart> getCartById(Long id);

    Cart updateCart(Long id,Long productId, CartDTO cartDTO);

    void deleteCart(Long id);
   
    

} 

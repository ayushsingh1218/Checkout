package com.example3.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example3.ecommerce.dto.CartDTO;
import com.example3.ecommerce.enitity.Cart;
import com.example3.ecommerce.service.CartService;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/{productId}/{quentity}")
    public Cart addToCart(@PathVariable Long userId, @PathVariable Long productId, @PathVariable int quentity) {    
        return cartService.addTocart(userId,productId,quentity);
    }
    
    @GetMapping("/userId/{userId}")
    public List<Cart> getCartByUserId(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @GetMapping("/{id}")
    public Optional<Cart> getCartById(@PathVariable Long id) {
        return  cartService.getCartById(id);
    }

    @PutMapping("/update/{id}/{productId}")
    public Cart updateCart(@PathVariable Long id,@PathVariable Long productId, @RequestBody CartDTO cartDTO) {    
        return cartService.updateCart(id,productId, cartDTO);
    }

    
   @DeleteMapping("/delete/{id}")
   public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
   }
} 

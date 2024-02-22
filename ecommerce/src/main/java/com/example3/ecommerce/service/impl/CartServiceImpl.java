package com.example3.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example3.ecommerce.dto.CartDTO;
import com.example3.ecommerce.enitity.Cart;
import com.example3.ecommerce.enitity.Product;
import com.example3.ecommerce.enitity.User;
import com.example3.ecommerce.repository.CartRepository;
import com.example3.ecommerce.repository.ProductRepository;
import com.example3.ecommerce.repository.UserRepository;
import com.example3.ecommerce.service.CartService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart addTocart(Long userId, Long productId, int quantity) {
      
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found."));
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found."));

        Cart exitinCart =  cartRepository.findByUserAndProduct(user , product);
        if (exitinCart!=null) {
            exitinCart.setQuantity(exitinCart.getQuantity() + quantity);
            exitinCart.setTotalprice(exitinCart.getTotalprice() + (product.getPrice() * quantity));
            return cartRepository.save(exitinCart);
        }
        else {
            Cart cart = new Cart();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setQuantity(quantity);
            cart.setTotalprice(product.getPrice()*quantity);
            return cartRepository.save(cart);
        }
    }

    @Override
    public List<Cart> getCartByUserId(Long userId)
    {
       return cartRepository.findByUserId(userId);
    }

   
    @Override
    public Optional<Cart> getCartById(Long id) 
    {
        return cartRepository.findById(id);
    }

    @Override
    public Cart updateCart(Long id,Long productId, CartDTO cartDTO) {
        Optional<Cart> optionalcart = cartRepository.findById(id);
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found."));
       
        if(optionalcart.isPresent()) {
            Cart cart = optionalcart.get();
            double price = product.getPrice();
            cart.setQuantity(cartDTO.getQuantity());
            cart.setTotalprice(cartDTO.getQuantity()*price);
            return cartRepository.save(cart);
        }
        else {
            throw new EntityNotFoundException("Cart not found with id: " + id); 
        }
    }

    @Override
    public void deleteCart(Long id) {
       cartRepository.deleteById(id);
    }

    

    
}

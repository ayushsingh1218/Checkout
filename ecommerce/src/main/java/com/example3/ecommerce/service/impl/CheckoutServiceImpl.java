package com.example3.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example3.ecommerce.enitity.Cart;
import com.example3.ecommerce.enitity.Checkout;
import com.example3.ecommerce.enitity.User;
import com.example3.ecommerce.repository.CartRepository;
import com.example3.ecommerce.repository.CheckoutRepository;
import com.example3.ecommerce.repository.UserRepository;
import com.example3.ecommerce.service.CheckoutService;


@Service
public class CheckoutServiceImpl implements CheckoutService{

    @Autowired
    private UserRepository userrRepository;
    
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;
    
    
    @Override
    public Checkout ByUser(Long userID) {
       User user = userrRepository.findById(userID).orElseThrow(() -> new IllegalArgumentException("User not found."));
       List<Cart> cart = cartRepository.findByUserId(userID);

       double totalamount = cart.stream()
                                .mapToDouble(car -> car.getProduct().getPrice() * car.getQuantity())
                                .sum();
       Checkout checkout = new Checkout();
       checkout.setUser(user);
       checkout.setCart(cart);
       checkout.setTotalamount(totalamount);
       return checkoutRepository.save(checkout);


       
    }
    
}

package com.example3.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example3.ecommerce.enitity.Checkout;
import com.example3.ecommerce.service.CheckoutService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    
    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/{userId}")
    public Checkout ByUser(@PathVariable Long userID) {  
        return checkoutService.ByUser(userID);
    }
    


}

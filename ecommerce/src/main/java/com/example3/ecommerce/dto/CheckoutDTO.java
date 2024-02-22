package com.example3.ecommerce.dto;

import java.util.List;

import lombok.Data;

@Data
public class CheckoutDTO {
    private Long userId;
    
    private double totalamount;
}

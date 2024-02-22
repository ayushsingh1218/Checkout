package com.example3.ecommerce.dto;

import lombok.Data;

@Data
public class CartDTO {
    
    private Long userId;
    private Long productId;
    private int quantity;
    private double totalprice;
   

}

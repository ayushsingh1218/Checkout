package com.example3.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.example3.ecommerce.dto.ProductDTO;
import com.example3.ecommerce.enitity.Product;

public interface ProductService {

    Product createProduct(ProductDTO productDTO);

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product updateProduct(Long id, ProductDTO productDTO);

    void deleteProduct(Long id);

    
} 

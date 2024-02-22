package com.example3.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example3.ecommerce.dto.ProductDTO;
import com.example3.ecommerce.enitity.Product;
import com.example3.ecommerce.repository.ProductRepository;
import com.example3.ecommerce.service.ProductService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService{
    

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
       return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Long id, ProductDTO productDTO) {
       Optional<Product> optionalproduct = productRepository.findById(id);
       if(optionalproduct.isPresent()) {
            Product product =  optionalproduct.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            return productRepository.save(product);
       }
       else {
        throw new EntityNotFoundException("Product not found with id: " + id);
       }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}

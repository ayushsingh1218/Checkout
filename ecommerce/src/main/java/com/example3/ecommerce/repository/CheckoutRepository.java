package com.example3.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example3.ecommerce.enitity.Checkout;


@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long>{

    
}

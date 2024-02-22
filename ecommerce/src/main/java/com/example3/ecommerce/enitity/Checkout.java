package com.example3.ecommerce.enitity;

import java.util.List;

import com.example3.ecommerce.dto.CartDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Checkout")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Checkout {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UserId" , nullable = false)
    @ManyToOne
    @JoinColumn(name = "user_Id" , referencedColumnName = "id")
    private User user;

    @Column(name = "Cart_Id" , nullable = false)
    @OneToMany
    @JoinColumn(name = "cart_id" , referencedColumnName = "id")
    private List<CartDTO> Cart;


    @Column(name = "Total_Amount" , nullable = false)
    private double totalamount;


    public void setCart(List<com.example3.ecommerce.enitity.Cart> cart2)
    {
        
    }



}

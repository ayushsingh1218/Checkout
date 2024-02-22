package com.example3.ecommerce.enitity;



// import org.hibernate.mapping.ManyToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "Cart" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    private Product product;

    @Column(name = "Quantity" , nullable = false)
    private int quantity;

    @Column(name ="Total_Price" , nullable = false)
    private double totalprice;

    
    public void updateTotalPrice() {
        this.totalprice = this.product.getPrice() * this.quantity;
    }
}

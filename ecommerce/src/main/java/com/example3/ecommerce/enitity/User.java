package com.example3.ecommerce.enitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "User_Name" , nullable = false)
    private String name;

    @Column(name = "User_Number" , nullable = false)
    private int mobile;

    @Column(name = "User_Email" , nullable = false)
    private String email;

    @Column(name = "User_Password" , nullable = false)

    private String password;

   

  
    
}
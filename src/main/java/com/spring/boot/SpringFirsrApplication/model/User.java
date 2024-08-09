package com.spring.boot.SpringFirsrApplication.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="user_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="user_first_name",nullable = false)
    private String firstName;
    @Column(name="user_last_name")
    private String lastName;
    @Column(name = "user_email",nullable = false,unique = true)
    private String email;
    @Column(name ="user_phoneNumber",nullable = false,unique = true)
    private long phoneNumber;



}

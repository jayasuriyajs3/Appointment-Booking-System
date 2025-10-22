package com.example.abs.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "join_date")
    private java.time.LocalDateTime joinDate = java.time.LocalDateTime.now();

    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<appointment> appointments;
}

package com.example.abs.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "doctors")
public class doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    private String name;

    private String specialization;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "experience_years")
    private int experienceYears;

    @Column(name = "available_days")
    private String availableDays; // e.g., "Mon-Fri"

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<appointment> appointments;
}

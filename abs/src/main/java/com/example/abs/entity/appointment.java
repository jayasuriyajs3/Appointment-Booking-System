package com.example.abs.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "appointments")
public class appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private doctor doctor;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    private String status; // e.g., "Scheduled", "Completed", "Cancelled"

    private String remarks;
}

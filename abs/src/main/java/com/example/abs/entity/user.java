package com.example.abs.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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
    private List<appointment> appointments = new ArrayList<>();

    public user() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public java.time.LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(java.time.LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public List<appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<appointment> appointments) {
        this.appointments = appointments;
    }
}

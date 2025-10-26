package com.example.abs.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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
    private List<appointment> appointments = new ArrayList<>();

    public doctor() {
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String availableDays) {
        this.availableDays = availableDays;
    }

    public List<appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<appointment> appointments) {
        this.appointments = appointments;
    }
}

package com.example.abs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.abs.entity.appointment;

public interface appointmentrepository extends JpaRepository<appointment, Long> {
}

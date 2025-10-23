package com.example.abs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.abs.entity.doctor;

public interface doctorrepository extends JpaRepository<doctor, Long> {
}


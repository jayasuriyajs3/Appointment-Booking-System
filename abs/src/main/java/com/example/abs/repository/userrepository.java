package com.example.abs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.abs.entity.user;

public interface userrepository extends JpaRepository<user, Long> {
}

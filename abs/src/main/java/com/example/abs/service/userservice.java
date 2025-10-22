package com.example.abs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abs.entity.user;
import com.example.abs.repository.userrepository;

@Service
public class userservice {

    @Autowired
    private userrepository userRepository;

    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<user> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public user createUser(user user) {
        return userRepository.save(user);
    }

    public user updateUser(Long id, user userDetails) {
        user user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setContactNo(userDetails.getContactNo());
        user.setJoinDate(userDetails.getJoinDate());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

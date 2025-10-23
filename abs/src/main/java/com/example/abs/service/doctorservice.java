package com.example.abs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abs.entity.doctor;
import com.example.abs.repository.doctorrepository;

@Service
public class doctorservice {

    @Autowired
    private doctorrepository doctorRepository;

    public List<doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public doctor createDoctor(doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public doctor updateDoctor(Long id, doctor doctorDetails) {
        doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setContactNo(doctorDetails.getContactNo());
        doctor.setEmail(doctorDetails.getEmail());
        doctor.setExperienceYears(doctorDetails.getExperienceYears());
        doctor.setAvailableDays(doctorDetails.getAvailableDays());
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}

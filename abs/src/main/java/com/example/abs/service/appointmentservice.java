package com.example.abs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abs.entity.appointment;
import com.example.abs.repository.appointmentrepository;

@Service
public class appointmentservice {

    @Autowired
    private appointmentrepository appointmentRepository;

    @Autowired
    private com.example.abs.repository.userrepository userRepository;

    @Autowired
    private com.example.abs.repository.doctorrepository doctorRepository;

    public List<appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public appointment createAppointment(appointment appointment) {
        // If the incoming appointment has nested user/doctor objects with only IDs,
        // fetch references from DB to avoid transient entity errors.
        if (appointment.getUser() != null && appointment.getUser().getUserId() != null) {
            appointment.setUser(userRepository.findById(appointment.getUser().getUserId()).orElseThrow());
        }
        if (appointment.getDoctor() != null && appointment.getDoctor().getDoctorId() != null) {
            appointment.setDoctor(doctorRepository.findById(appointment.getDoctor().getDoctorId()).orElseThrow());
        }
        return appointmentRepository.save(appointment);
    }

    public appointment updateAppointment(Long id, appointment appointmentDetails) {
        appointment appointment = appointmentRepository.findById(id).orElseThrow();

        if (appointmentDetails.getUser() != null && appointmentDetails.getUser().getUserId() != null) {
            appointment.setUser(userRepository.findById(appointmentDetails.getUser().getUserId()).orElseThrow());
        }
        if (appointmentDetails.getDoctor() != null && appointmentDetails.getDoctor().getDoctorId() != null) {
            appointment
                    .setDoctor(doctorRepository.findById(appointmentDetails.getDoctor().getDoctorId()).orElseThrow());
        }
        appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
        appointment.setStatus(appointmentDetails.getStatus());
        appointment.setRemarks(appointmentDetails.getRemarks());

        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}

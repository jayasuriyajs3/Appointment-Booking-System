package com.example.abs.service;

import com.example.abs.entity.*;
import com.example.abs.repository.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    @Mock
    private appointmentrepository appointmentRepository;

    @Mock
    private userrepository userRepository;

    @Mock
    private doctorrepository doctorRepository;

    @InjectMocks
    private appointmentservice appointmentService;

    public AppointmentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAppointments() {
        when(appointmentRepository.findAll()).thenReturn(Arrays.asList(new appointment(), new appointment()));
        assertEquals(2, appointmentService.getAllAppointments().size());
    }

    @Test
    void testCreateAppointment() {
        appointment a = new appointment();
        a.setStatus("Scheduled");
        when(appointmentRepository.save(a)).thenReturn(a);
        assertEquals("Scheduled", appointmentService.createAppointment(a).getStatus());
    }

    @Test
    void testDeleteAppointment() {
        appointmentService.deleteAppointment(2L);
        verify(appointmentRepository, times(1)).deleteById(2L);
    }
}

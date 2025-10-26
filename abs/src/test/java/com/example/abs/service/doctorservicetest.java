package com.example.abs.service;

import com.example.abs.entity.doctor;
import com.example.abs.repository.doctorrepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceTest {

    @Mock
    private doctorrepository doctorRepository;

    @InjectMocks
    private doctorservice doctorService;

    public DoctorServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDoctors() {
        when(doctorRepository.findAll()).thenReturn(Arrays.asList(new doctor(), new doctor()));
        assertEquals(2, doctorService.getAllDoctors().size());
    }

    @Test
    void testCreateDoctor() {
        doctor d = new doctor();
        d.setName("Dr. Test");
        when(doctorRepository.save(d)).thenReturn(d);
        assertEquals("Dr. Test", doctorService.createDoctor(d).getName());
    }

    @Test
    void testDeleteDoctor() {
        doctorService.deleteDoctor(5L);
        verify(doctorRepository, times(1)).deleteById(5L);
    }
}

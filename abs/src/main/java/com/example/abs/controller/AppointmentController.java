package com.example.abs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.abs.entity.appointment;
import com.example.abs.service.appointmentservice;
import com.example.abs.service.doctorservice;
import com.example.abs.service.userservice;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private appointmentservice appointmentService;

    @Autowired
    private userservice userService;

    @Autowired
    private doctorservice doctorService;

    @GetMapping
    public String getAllAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointments/list";
    }

    @GetMapping("/new")
    public String createAppointmentForm(Model model) {
        model.addAttribute("appointment", new appointment());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "appointments/form";
    }

    @PostMapping
    public String createAppointment(@ModelAttribute appointment appointment) {
        appointmentService.createAppointment(appointment);
        return "redirect:/appointments";
    }

    // JSON endpoint for Postman: POST /appointments with application/json
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<appointment> createAppointmentJson(@RequestBody appointment appointment) {
        appointment saved = appointmentService.createAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/edit/{id}")
    public String editAppointmentForm(@PathVariable Long id, Model model) {
        model.addAttribute("appointment", appointmentService.getAppointmentById(id).orElseThrow());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "appointments/form";
    }

    @PostMapping("/update/{id}")
    public String updateAppointment(@PathVariable Long id, @ModelAttribute appointment appointment) {
        appointmentService.updateAppointment(id, appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}

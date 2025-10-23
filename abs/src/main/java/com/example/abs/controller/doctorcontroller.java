package com.example.abs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.abs.entity.doctor;
import com.example.abs.service.doctorservice;

@Controller
@RequestMapping("/doctors")
public class doctorcontroller {

    @Autowired
    private doctorservice doctorService;

    @GetMapping
    public String getAllDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors/list"; // Thymeleaf view (list.html)
    }

    @GetMapping("/new")
    public String createDoctorForm(Model model) {
        model.addAttribute("doctor", new doctor());
        return "doctors/form"; // Thymeleaf view (form.html)
    }

    @PostMapping
    public String createDoctor(@ModelAttribute doctor doctor) {
        doctorService.createDoctor(doctor);
        return "redirect:/doctors";
    }

    // Accept JSON requests from Postman: POST /doctors with Content-Type:
    // application/json
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<doctor> createDoctorJson(@RequestBody doctor doctor) {
        doctor saved = doctorService.createDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/edit/{id}")
    public String editDoctorForm(@PathVariable Long id, Model model) {
        model.addAttribute("doctor", doctorService.getDoctorById(id).orElseThrow());
        return "doctors/form";
    }

    @PostMapping("/update/{id}")
    public String updateDoctor(@PathVariable Long id, @ModelAttribute doctor doctor) {
        doctorService.updateDoctor(id, doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }
}

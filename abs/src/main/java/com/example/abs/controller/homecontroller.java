package com.example.abs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homecontroller {

    @GetMapping({ "/", "/home" })
    public String home() {
        return "home";
    }
}

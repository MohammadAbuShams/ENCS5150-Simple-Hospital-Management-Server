package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // GET request to print a string
    @GetMapping("/")
    public String welcome() {
        return "Welcome, I'm Mohammad Abu Shams"; // Make sure YOUR_NAME is replaced with the actual name.
    }
}

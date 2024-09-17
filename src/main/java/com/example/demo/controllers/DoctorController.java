package com.example.demo.controllers;

import com.example.demo.hospital.Doctor;
import com.example.demo.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private HospitalService hospitalService;

    // GET request to retrieve a doctor by ID
    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long doctorId) {
        return hospitalService.getDoctor(doctorId)
                .map(doctor -> new ResponseEntity<>(doctor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET request to retrieve all doctors
    @GetMapping("/")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> allDoctors = hospitalService.getAllDoctors();
        if (allDoctors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allDoctors, HttpStatus.OK);
    }

    // POST request to add a new doctor
    @PostMapping("/")
    public ResponseEntity<Boolean> addDoctor(@RequestBody Doctor doctor) {
        boolean added = hospitalService.addDoctor(doctor);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }


    // DELETE request to remove a doctor
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Boolean> deleteDoctor(@PathVariable Long doctorId) {
        boolean deleted = hospitalService.deleteDoctor(doctorId);
        if (deleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }




}

package com.example.demo.controllers;

import com.example.demo.hospital.Doctor;
import com.example.demo.hospital.Patient;
import com.example.demo.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private HospitalService hospitalService;

    // GET request to retrieve a patient by ID
    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long patientId) {
        return hospitalService.getPatient(patientId)
                .map(patient -> new ResponseEntity<>(patient, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    // GET request to retrieve all patients
    @GetMapping("/")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = hospitalService.getAllPatients();
        if (patients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // POST request to add a new patient
    @PostMapping("/")
    public ResponseEntity<Boolean> addPatient(@RequestBody Patient patient) {
        boolean added = hospitalService.addPatient(patient);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }


    // DELETE request to remove a patient
    @DeleteMapping("/{patientId}")
    public ResponseEntity<Boolean> deletePatient(@PathVariable Long patientId) {
        boolean deleted = hospitalService.deletePatient(patientId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }





}

package com.example.demo.controllers;

import com.example.demo.hospital.Patient;
import com.example.demo.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class GlobalOperationsController {

    @Autowired
    private HospitalService hospitalService;


    //POST endpoint to assign a doctor to a patient
    @PostMapping("/assign/{doctorId}")
    public ResponseEntity<?> assignDoctorToPatient(@PathVariable Long doctorId, @RequestBody Map<String, Long> body) {
        try {
            Long patientId = body.get("patientId");
            boolean assigned = hospitalService.assignDoctorToPatient(doctorId, patientId);
            return ResponseEntity.ok(assigned);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error processing request: " + e.getMessage());
        }
    }



    // PUT endpoint to release a patient
    @PutMapping("/release/{patientId}")
    public ResponseEntity<Boolean> releasePatient(@PathVariable Long patientId) {
        Optional<Patient> patientOptional = hospitalService.getPatient(patientId);

        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            patient.setIsCured(true);
            patient.getDoctors().clear();
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }



}

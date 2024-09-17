package com.example.demo.services;

import com.example.demo.hospital.Doctor;
import com.example.demo.hospital.Patient;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Patient> patients = new ArrayList<>();

    @PostConstruct
    public void initData() {
        doctors.add(new Doctor(1L, "Dr. Mohammad Abu Shams", 5, 0, 15.5));
        doctors.add(new Doctor(2L, "Dr. Mohammad Balawi", 3, 2, 7.0));
        doctors.add(new Doctor(3L, "Dr. Saeed Ahmad", 10, 3, 20.0));
        doctors.add(new Doctor(4L, "Dr. Hala Khaled", 7, 1, 12.0));


        patients.add(new Patient(1L, "Jana Ali", 5.0, false, new ArrayList<>()));
        patients.add(new Patient(2L, "Qais Ibraheem", 10.0, false, new ArrayList<>()));
        patients.add(new Patient(3L, "Layan Osama", 7.5, false, new ArrayList<>()));
        patients.add(new Patient(4L, "Rami Jaber", 6.5, false, new ArrayList<>()));

    }

    // Doctor methods
    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors); // Return a copy of the list
    }

    public Optional<Doctor> getDoctor(Long doctorId) {
        return doctors.stream().filter(d -> d.getId().equals(doctorId)).findFirst();
    }

    public boolean addDoctor(Doctor doctor) {
        return doctors.add(doctor);
    }

    public boolean updateDoctor(Long doctorId, Doctor updatedDoctor) {
        Optional<Doctor> doctorOptional = getDoctor(doctorId);
        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            doctor.setName(updatedDoctor.getName());
            doctor.setMaxPatients(updatedDoctor.getMaxPatients());
            doctor.setCurrentPatients(updatedDoctor.getCurrentPatients());
            doctor.setExperience(updatedDoctor.getExperience());
            return true;
        }
        return false;
    }

    public boolean deleteDoctor(Long doctorId) {
        return doctors.removeIf(d -> d.getId().equals(doctorId));
    }

    // Patient methods
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients); // Return a copy of the list
    }

    public Optional<Patient> getPatient(Long patientId) {
        return patients.stream().filter(p -> p.getId().equals(patientId)).findFirst();
    }

    public boolean addPatient(Patient patient) {
        return patients.add(patient);
    }

    public boolean updatePatient(Long patientId, Patient updatedPatient) {
        Optional<Patient> patientOptional = getPatient(patientId);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            patient.setName(updatedPatient.getName());
            patient.setIllnessExperienceRequirement(updatedPatient.getIllnessExperienceRequirement());
            patient.setIsCured(updatedPatient.getIsCured());
            patient.setDoctors(updatedPatient.getDoctors());
            return true;
        }
        return false;
    }

    public boolean deletePatient(Long patientId) {
        return patients.removeIf(p -> p.getId().equals(patientId));
    }


    public Patient releasePatient(Long patientId) {
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                patient.setIsCured(true);
                patient.getDoctors().clear(); // Clear the list of doctors
                return patient;
            }
        }
        return null; // Return null if no patient found
    }


    public boolean assignDoctorToPatient(Long doctorId, Long patientId) {
        Doctor doctor = findDoctorById(doctorId);
        Patient patient = findPatientById(patientId);
        if (doctor != null && patient != null &&
                doctor.getExperience() >= patient.getIllnessExperienceRequirement() &&
                doctor.getCurrentPatients() < doctor.getMaxPatients()) {

            doctor.setCurrentPatients(doctor.getCurrentPatients() + 1);
            patient.getDoctors().add(doctor.getId());
            return true;
        }
        return false;
    }


    private Doctor findDoctorById(Long id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null; // Return null if no matching doctor is found
    }


    private Patient findPatientById(Long id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null; // Return null if no matching patient is found
    }



}

package com.example.demo.hospital;

import java.util.ArrayList;

public class Patient {
    private Long id;
    private String name;
    private double illnessExperienceRequirement;
    private Boolean isCured;
    private ArrayList<Long> doctors;

    public Patient() {
        this.isCured = false; // Initial value as per your specification
        this.doctors = new ArrayList<>(); // Initialize to ensure there's no null pointer exception
    }

    public Patient(Long id, String name, double illnessExperienceRequirement, Boolean isCured, ArrayList<Long> doctors) {
        this.id = id;
        this.name = name;
        this.illnessExperienceRequirement = illnessExperienceRequirement;
        this.isCured = isCured;
        this.doctors = doctors;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getIllnessExperienceRequirement() {
        return illnessExperienceRequirement;
    }

    public Boolean getIsCured() {
        return isCured;
    }

    public ArrayList<Long> getDoctors() {
        return doctors;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIllnessExperienceRequirement(double illnessExperienceRequirement) {
        this.illnessExperienceRequirement = illnessExperienceRequirement;
    }

    public void setIsCured(Boolean isCured) {
        this.isCured = isCured;
    }

    public void setDoctors(ArrayList<Long> doctors) {
        this.doctors = doctors;
    }

    // To String method
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", illnessExperienceRequirement=" + illnessExperienceRequirement +
                ", isCured=" + isCured +
                ", doctors=" + doctors +
                '}';
    }
}

package com.example.demo.hospital;

public class Doctor {
    private Long id;
    private String name;
    private int maxPatients;
    private int currentPatients;
    private double experience;

    public Doctor() {
    }

    public Doctor(Long id, String name, int maxPatients, int currentPatients, double experience) {
        this.id = id;
        this.name = name;
        this.maxPatients = maxPatients;
        this.currentPatients = currentPatients;
        this.experience = experience;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxPatients() {
        return maxPatients;
    }

    public int getCurrentPatients() {
        return currentPatients;
    }

    public double getExperience() {
        return experience;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxPatients(int maxPatients) {
        this.maxPatients = maxPatients;
    }

    public void setCurrentPatients(int currentPatients) {
        this.currentPatients = currentPatients;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    // To String method
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxPatients=" + maxPatients +
                ", currentPatients=" + currentPatients +
                ", experience=" + experience +
                '}';
    }
}

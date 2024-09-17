# Simple Hospital Management Server

## Overview

This Spring Boot application provides a RESTful API for managing a hospital system, including endpoints for handling doctors and patients. The system allows for CRUD operations and specific functionalities such as assigning doctors to patients and releasing patients.

## Features

- **Doctor Management:**
  - Retrieve, add, and delete doctors.
  - Assign doctors to patients based on experience and availability.

- **Patient Management:**
  - Retrieve, add, and delete patients.
  - Release patients and remove associated doctors.

- **Endpoints:**
  - GET, POST, DELETE, PUT requests for managing doctors and patients.
  - Assignment of doctors to patients.
  - Patient release functionality.

## API Endpoints

### Doctors

- **Retrieve Doctor Information**
  - `GET /doctors/{doctorId}` - Retrieves information of a specific doctor.
  
- **Retrieve All Doctors**
  - `GET /doctors` - Retrieves information of all doctors.

- **Add a New Doctor**
  - `POST /doctors` - Adds a new doctor. (Request Body: Doctor object)

- **Delete a Doctor**
  - `DELETE /doctors/{doctorId}` - Deletes the specified doctor.

### Patients

- **Retrieve Patient Information**
  - `GET /patients/{patientId}` - Retrieves information of a specific patient.

- **Retrieve All Patients**
  - `GET /patients` - Retrieves information of all patients.

- **Add a New Patient**
  - `POST /patients` - Adds a new patient. (Request Body: Patient object)

- **Delete a Patient**
  - `DELETE /patients/{patientId}` - Deletes the specified patient.

### Assignment

- **Assign Doctor to Patient**
  - `POST /assign/{doctorId}` - Assigns a doctor to a patient. (Request Body: Long patientId)
  - Returns `true` if assignment is successful, otherwise `false`.

### Release

- **Release Patient**
  - `PUT /release/{patientId}` - Releases a patient and removes associated doctors.
  - Returns `true` if release is successful, otherwise `false`.

### Welcome Message

- **Root Path**
  - `GET /` - Returns a welcome message: "Welcome, I’m YOUR_NAME".

## Data Storage

- **Storage Mechanism:**
  - Uses `ArrayList` for in-memory data storage. No database is required.

## Error Handling

- Provides appropriate error messages for incorrect requests, such as requesting non-existing patients or doctors.

## Testing

- Test the API endpoints using Postman to ensure they work correctly.

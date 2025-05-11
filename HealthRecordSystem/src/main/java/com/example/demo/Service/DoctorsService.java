package com.example.demo.Service;

import com.example.demo.Model.Doctors;
import com.example.demo.Repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {

    @Autowired
    private DoctorsRepository doctorsRepository;

    public List<Doctors> getAllDoctors() {
        return doctorsRepository.findAll();
    }

    public Optional<Doctors> getDoctorById(Long id) {
        return doctorsRepository.findById(id);
    }

    public Doctors addDoctor(Doctors doctor) {
        return doctorsRepository.save(doctor);
    }

    public Doctors updateDoctor(Long id, Doctors updatedDoctor) {
        return doctorsRepository.findById(id).map(existingDoctor -> {
            existingDoctor.setName(updatedDoctor.getName());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            existingDoctor.setEmail(updatedDoctor.getEmail());
            existingDoctor.setPhone(updatedDoctor.getPhone());
            return doctorsRepository.save(existingDoctor);
        }).orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    public void deleteDoctor(Long id) {
        doctorsRepository.deleteById(id);
    }
    
    public Doctors signup(Doctors doctor) {
        // Optional: Check if email exists
        if (doctorsRepository.findByEmail(doctor.getEmail()).isPresent()) {
            throw new RuntimeException("Doctor already exists with this email");
        }
        return doctorsRepository.save(doctor);
    }

    public Doctors signin(String email, String password) {
        Doctors doctor = doctorsRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Doctor not found with email: " + email));
        if (!doctor.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }
        return doctor;
    }
}

package com.example.demo.Service;

import com.example.demo.Model.Patients;
import com.example.demo.Repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientsService {

    @Autowired
    private PatientsRepository patientsRepository;

    public List<Patients> getAllPatients() {
        return patientsRepository.findAll();
    }

    public Optional<Patients> getPatientById(Long id) {
        return patientsRepository.findById(id);
    }

    public Patients addPatient(Patients patient) {
        return patientsRepository.save(patient);
    }

    public Patients updatePatient(Long id, Patients updatedPatient) {
        return patientsRepository.findById(id).map(existingPatient -> {
            existingPatient.setName(updatedPatient.getName());
            existingPatient.setAge(updatedPatient.getAge());
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setEmail(updatedPatient.getEmail());
            existingPatient.setPhone(updatedPatient.getPhone());
            existingPatient.setHealthIssue(updatedPatient.getHealthIssue());

            // Medical fields
            existingPatient.setBp(updatedPatient.getBp());
            existingPatient.setHemoglobin(updatedPatient.getHemoglobin());
            existingPatient.setPlatelets(updatedPatient.getPlatelets());
            existingPatient.setLymphocytes(updatedPatient.getLymphocytes());
            existingPatient.setSgot(updatedPatient.getSgot());
            existingPatient.setSgpt(updatedPatient.getSgpt());

            return patientsRepository.save(existingPatient);
        }).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public void deletePatient(Long id) {
        patientsRepository.deleteById(id);
    }

    public Patients signup(Patients patient) {
        if (patientsRepository.findByEmail(patient.getEmail()).isPresent()) {
            throw new RuntimeException("Patient already exists with this email");
        }
        return patientsRepository.save(patient);
    }

    public Patients signin(String email, String password) {
        Patients patient = patientsRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Patient not found with this email"));

        if (!patient.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return patient;
    }
}

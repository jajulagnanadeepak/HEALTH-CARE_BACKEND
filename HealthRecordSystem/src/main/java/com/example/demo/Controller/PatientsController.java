package com.example.demo.Controller;

import com.example.demo.Model.Patients;
import com.example.demo.Model.SignInRequest;
import com.example.demo.Service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    // GET /api/patients
    @GetMapping
    public List<Patients> getAllPatients() {
        return patientsService.getAllPatients();
    }

    // GET /api/patients/{id}
    @GetMapping("/{id}")
    public Optional<Patients> getPatientById(@PathVariable Long id) {
        return patientsService.getPatientById(id);
    }

    // POST /api/patients
    @PostMapping
    public Patients addPatient(@RequestBody Patients patient) {
        return patientsService.addPatient(patient);
    }

    // PUT /api/patients/{id}
    @PutMapping("/{id}")
    public Patients updatePatient(@PathVariable Long id, @RequestBody Patients updatedPatient) {
        return patientsService.updatePatient(id, updatedPatient);
    }

    // DELETE /api/patients/{id}
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientsService.deletePatient(id);
    }
    
    public Patients signup(@RequestBody Patients patient) {
        return patientsService.signup(patient);
    }

    @PostMapping("/signin")
    public Patients signin(@RequestBody SignInRequest request) {
        return patientsService.signin(request.getEmail(), request.getPassword());
    }
}

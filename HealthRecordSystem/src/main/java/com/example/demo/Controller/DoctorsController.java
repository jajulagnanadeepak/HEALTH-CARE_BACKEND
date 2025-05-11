package com.example.demo.Controller;

import com.example.demo.Model.Doctors;
import com.example.demo.Model.SignInRequest;
import com.example.demo.Service.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173/*")
@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @GetMapping
    public List<Doctors> getAllDoctors() {
        return doctorsService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctors getDoctorById(@PathVariable Long id) {
        return doctorsService.getDoctorById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    @PostMapping
    public Doctors addDoctor(@RequestBody Doctors doctor) {
        return doctorsService.addDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctors updateDoctor(@PathVariable Long id, @RequestBody Doctors doctor) {
        return doctorsService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorsService.deleteDoctor(id);
    }
    
    @PostMapping("/signup")
    public Doctors signup(@RequestBody Doctors doctor) {
        return doctorsService.signup(doctor);
    }

    @PostMapping("/signin")
    public Doctors signin(@RequestBody SignInRequest request) {
        return doctorsService.signin(request.getEmail(), request.getPassword());
    }
    
    
}

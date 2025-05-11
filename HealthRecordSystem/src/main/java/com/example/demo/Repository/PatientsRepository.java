package com.example.demo.Repository;

import com.example.demo.Model.Patients;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {
	  Optional<Patients> findByEmail(String email);
	}


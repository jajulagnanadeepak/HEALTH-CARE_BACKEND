package com.example.demo.Repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Doctors;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {
	 Optional<Doctors> findByEmail(String email);
}

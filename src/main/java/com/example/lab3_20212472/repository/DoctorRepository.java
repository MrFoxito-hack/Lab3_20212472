package com.example.lab3_20212472.repository;

import com.example.lab3_20212472.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}

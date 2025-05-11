package com.example.lab3_20212472.repository;

import com.example.lab3_20212472.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}

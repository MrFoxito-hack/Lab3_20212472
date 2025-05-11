package com.example.lab3_20212472.repository;

import com.example.lab3_20212472.entity.Paciente;
import com.example.lab3_20212472.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> findByHospital(Hospital hospital);
}

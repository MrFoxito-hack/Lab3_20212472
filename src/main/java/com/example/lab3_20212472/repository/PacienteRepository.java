package com.example.lab3_20212472.repository;

import com.example.lab3_20212472.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}

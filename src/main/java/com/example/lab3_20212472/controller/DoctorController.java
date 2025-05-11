package com.example.lab3_20212472.controller;

import com.example.lab3_20212472.entity.Doctor;
import com.example.lab3_20212472.entity.Paciente;
import com.example.lab3_20212472.repository.DoctorRepository;
import com.example.lab3_20212472.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // Mostrar la lista de doctores
    @GetMapping("/doctores")
    public String verDoctores(Model model) {
        model.addAttribute("doctores", doctorRepository.findAll());
        return "doctores"; // Vista donde se muestran los doctores
    }

    // Mostrar los pacientes no atendidos por un doctor
    @GetMapping("/proximasCitas/{doctorId}")
    public String mostrarProximasCitas(@PathVariable("doctorId") int doctorId, Model model) {
        model.addAttribute("pacientes", pacienteRepository.findProximasCitasPorDoctor(doctorId));
        return "proximasCitas"; // Nombre de la vista HTML que mostrará las citas
    }
}

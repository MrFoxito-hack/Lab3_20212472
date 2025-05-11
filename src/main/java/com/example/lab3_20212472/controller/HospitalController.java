package com.example.lab3_20212472.controller;

import com.example.lab3_20212472.entity.Doctor;
import com.example.lab3_20212472.entity.Paciente;
import com.example.lab3_20212472.entity.Hospital;
import com.example.lab3_20212472.repository.DoctorRepository;
import com.example.lab3_20212472.repository.PacienteRepository;
import com.example.lab3_20212472.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HospitalController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    // Ver la lista de hospitales
    @GetMapping("/hospitales")
    public String verHospitales(Model model) {
        model.addAttribute("hospitales", hospitalRepository.findAll());
        return "hospitales";
    }

    @GetMapping("/mostrarDoctores/{hospitalId}")
    public String verDoctoresPorHospital(@PathVariable("hospitalId") int hospitalId, Model model) {
        Hospital hospital = hospitalRepository.findById(hospitalId).orElse(null);
        if (hospital != null) {
            model.addAttribute("doctores", doctorRepository.findByHospital(hospital));
        } else {
            model.addAttribute("doctores", null);
        }
        return "doctores";  // Página que muestra los doctores de un hospital
    }

    @GetMapping("/mostrarPacientes/{hospitalId}")
    public String verPacientesPorHospital(@PathVariable("hospitalId") int hospitalId, Model model) {
        Hospital hospital = hospitalRepository.findById(hospitalId).orElse(null);
        if (hospital != null) {
            model.addAttribute("pacientes", pacienteRepository.findByHospital(hospital));
        } else {
            model.addAttribute("pacientes", null);
        }
        return "pacientes";  // Página que muestra los pacientes de un hospital
    }
}

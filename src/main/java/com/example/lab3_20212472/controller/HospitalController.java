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

@Controller
public class HospitalController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @GetMapping("/doctores")
    public String verDoctores(Model model) {
        model.addAttribute("doctores", doctorRepository.findAll());
        return "doctores";
    }

    @GetMapping("/pacientes")
    public String verPacientes(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "pacientes";
    }

    @GetMapping("/hospitales")
    public String verHospitales(Model model) {
        model.addAttribute("hospitales", hospitalRepository.findAll());
        return "hospitales";
    }
}

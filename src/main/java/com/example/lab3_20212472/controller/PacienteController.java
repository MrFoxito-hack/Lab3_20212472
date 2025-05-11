package com.example.lab3_20212472.controller;

import com.example.lab3_20212472.entity.Paciente;
import com.example.lab3_20212472.entity.Doctor;
import com.example.lab3_20212472.entity.Paciente;

import com.example.lab3_20212472.repository.DoctorRepository;
import com.example.lab3_20212472.repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/pacientes")
    public String verPacientes(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "pacientes";
    }

    @GetMapping("/derivarPaciente/{id}")
    public String showDerivacionForm(@PathVariable("id") int pacienteId, Model model) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));

        List<Doctor> doctores = doctorRepository.findAll()
                .stream()
                .filter(doctor -> doctor.getId() != paciente.getDoctor().getId()) // Usa != en lugar de equals()
                .collect(Collectors.toList());

        model.addAttribute("paciente", paciente);
        model.addAttribute("doctores", doctores);
        return "derivarPaciente";
    }

    @PostMapping("/derivarPaciente/{id}")
    public String processDerivacion(@PathVariable("id") int pacienteId,
                                    @RequestParam("doctorDestino") Integer doctorDestinoId) {

        // Obtener el paciente por su ID
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));

        // Comparar el ID del doctor actual con el doctor al cual se quiere derivar
        if(paciente.getDoctor().getId() == doctorDestinoId) {  // Usar '==' para comparación de IDs
            throw new IllegalArgumentException("No puede derivar al mismo doctor");
        }

        // Obtener el nuevo doctor por su ID
        Doctor nuevoDoctor = doctorRepository.findById(doctorDestinoId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor destino no encontrado"));

        // Actualizar la relación entre el paciente y el nuevo doctor
        paciente.setDoctor(nuevoDoctor);

        // Guardar los cambios en el paciente
        pacienteRepository.save(paciente);

        // Redirigir a la lista de pacientes
        return "redirect:/pacientes";
    }





}


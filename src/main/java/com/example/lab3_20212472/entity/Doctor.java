package com.example.lab3_20212472.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public Doctor() {}
}

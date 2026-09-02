package com.example.Veterinaria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="Veterinario")
@Getter
@Setter

public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50)
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tarjeta", unique = true, nullable = false)
    private String tarjeta;

    @Email(message = "Debe ser un formato de correo válido")
    @Column(name = "correo", unique = true, nullable = false)
    private String correo;

    @Column(name = "especialidad", unique = true, nullable = false)
    private String especialidad;



}

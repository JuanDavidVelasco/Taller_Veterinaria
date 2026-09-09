package com.example.Veterinaria.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

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

    //Un veterinario ve a varias mascotas
    @ManyToMany(mappedBy = "veterinarios")
    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Mascota> mascotas = new ArrayList<>();


}

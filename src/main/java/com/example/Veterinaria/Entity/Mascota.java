package com.example.Veterinaria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="Mascotagit ")
@Getter
@Setter


public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el nombre no puede estar incompleto")
    @Size(min = 2,max = 12)
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "La especie es obligatoria")
    @Column(name = "especie", nullable = false)
    private String especie;

    @NotBlank(message = "La raza es obligatoria")
    @Column(name = "raza")
    private String raza;

    @Min(value = 0, message = "La edad no puede ser negativa")
    @Column(name = "edad")
    private Integer edad;

    @Positive(message = "El peso debe ser mayor a 0")
    @Column(name = "peso")
    private Double peso;


    }

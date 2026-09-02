package com.example.Veterinaria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="Propietario")
@Getter
@Setter

public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50)
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "documento", unique = true, nullable = false)
    private String documento;

    @Size(min = 7, max = 15)
    @Column(name = "telefono")
    private String telefono;

    @Email(message = "Debe ser un formato de correo válido")
    @Column(name = "correo", unique = true, nullable = false)
    private String correo;


}

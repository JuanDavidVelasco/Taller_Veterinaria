package com.example.Veterinaria.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name ="Mascota ")
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

    // Varias mascotas tienen un dueño
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "propietario_id", nullable = false)
    private Propietario propietario;

    // Una mascotas puede tener solo una historia clinica
    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL)
    private HistoriaClinica historiaClinica;

    // una mascota la pueden atender diferentes veterinartios
    @ManyToMany
    @JoinTable(
            name = "mascota_veterinario",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "veterinario_id")
    )
    private List<Veterinario> veterinarios;

    }

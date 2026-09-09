package com.example.Veterinaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name ="HistoriaClinica")
@Getter
@Setter

public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechas", nullable = false)
    private LocalDate fechas;

    @Column(name = "antecedentes", columnDefinition = "TEXT")
    private String antecedentes;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    // Uan historia clinica pertenece solo a una mascota
    @OneToOne
    @JoinColumn(name = "mascota_id", unique = true)
    private Mascota mascota;

}

package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {

}
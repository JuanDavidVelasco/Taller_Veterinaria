package com.example.Veterinaria.Service;

import com.example.Veterinaria.Entity.Veterinario;

import java.util.List;
import java.util.Optional;

public interface VeterinarioService {

    List<Veterinario> listarVeterinarios();

    Optional<Veterinario> buscarPropietarioPorId(Long id);

    Veterinario crearVeterinarios(Veterinario veterinario);

   void eliminarVeterinarios(Long id);

  Veterinario actualizarVeterinarios(Long id, Veterinario veterinario);
}
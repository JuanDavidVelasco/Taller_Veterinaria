package com.example.Veterinaria.Service;


import com.example.Veterinaria.Entity.Mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaService {

    List<Mascota> listarMascotas();

    Optional<Mascota> buscarMascotaPorId(Long id);

    Mascota crearMascota(Mascota mascota);

    void eliminarMascota(Long id);

    Mascota actualizarMascota(Long id, Mascota mascota);

    List<Mascota> listarPorPropietario(Long propietarioId );

    Mascota asignarMascotaxVeterinario(Long mascotaId, Long veterinarioId );

}
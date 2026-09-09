package com.example.Veterinaria.Service.ServiceImpl;

import com.example.Veterinaria.Entity.Propietario;
import com.example.Veterinaria.Exception.ResourceNotFoundException; // Importante: debes crear esta clase
import com.example.Veterinaria.Repository.PropietarioRepository;
import com.example.Veterinaria.Service.PropietarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PropietarioServiceImpl implements PropietarioService {

    private final PropietarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Propietario> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Propietario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Propietario no encontrado: " + id));
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return repository.save(propietario);
    }

    @Override
    public Propietario actualizar(Long id, Propietario propietario) {
        buscarPorId(id); // Valida que exista
        propietario.setId(id);
        return repository.save(propietario);
    }

    @Override
    public void eliminar(Long id) {
        buscarPorId(id); // Valida que exista
        repository.deleteById(id);
    }
}
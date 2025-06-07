package com.edutareas.service.impl;

import com.edutareas.model.Entrega;
import com.edutareas.repository.EntregaRepository;
import com.edutareas.service.EntregaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaServiceImpl implements EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregaServiceImpl(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    @Override
    public Entrega crearEntrega(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    @Override
    public Optional<Entrega> obtenerPorId(Long id) {
        return entregaRepository.findById(id);
    }

    @Override
    public List<Entrega> listarTodas() {
        return entregaRepository.findAll();
    }

    @Override
    public List<Entrega> listarPorEstudiante(Long estudianteId) {
        return entregaRepository.findByEstudianteId(estudianteId);
    }

    @Override
    public List<Entrega> listarPorTarea(Long tareaId) {
        return entregaRepository.findByTareaId(tareaId);
    }

    @Override
    public void eliminarEntrega(Long id) {
        entregaRepository.deleteById(id);
    }
}

package com.edutareas.service;

import com.edutareas.model.Entrega;

import java.util.List;
import java.util.Optional;

public interface EntregaService {
    Entrega crearEntrega(Entrega entrega);
    Optional<Entrega> obtenerPorId(Long id);
    List<Entrega> listarTodas();
    List<Entrega> listarPorEstudiante(Long estudianteId);
    List<Entrega> listarPorTarea(Long tareaId);
    void eliminarEntrega(Long id);
}

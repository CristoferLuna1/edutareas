package com.edutareas.service;

import com.edutareas.model.Observacion;

import java.util.List;
import java.util.Optional;

public interface ObservacionService {
    Observacion crearObservacion(Observacion observacion);
    Optional<Observacion> obtenerPorId(Long id);
    List<Observacion> listarTodas();
    List<Observacion> listarPorEstudiante(Long estudianteId);
    List<Observacion> listarPorDocente(Long docenteId);
    void eliminarObservacion(Long id);
}

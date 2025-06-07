package com.edutareas.service;

import com.edutareas.model.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaService {
    Tarea crearTarea(Tarea tarea);
    Optional<Tarea> obtenerPorId(Long id);
    List<Tarea> listarTodas();
    List<Tarea> listarPorCurso(Long cursoId);
    List<Tarea> listarPorDocente(Long docenteId);
    void eliminarTarea(Long id);
}

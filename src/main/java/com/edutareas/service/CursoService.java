package com.edutareas.service;

import com.edutareas.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    Curso crearCurso(Curso curso);
    Optional<Curso> obtenerPorId(Long id);
    List<Curso> listarTodos();
    List<Curso> listarPorDocente(Long docenteId);
    void eliminarCurso(Long id);
}


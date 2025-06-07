package com.edutareas.repository;

import com.edutareas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByCursoId(Long cursoId);
    List<Tarea> findByDocenteId(Long docenteId);
}

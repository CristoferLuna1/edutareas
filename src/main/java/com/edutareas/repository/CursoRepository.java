package com.edutareas.repository;

import com.edutareas.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByDocenteId(Long docenteId);
}

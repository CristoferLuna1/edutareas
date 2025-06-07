package com.edutareas.repository;

import com.edutareas.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    List<Entrega> findByEstudianteId(Long estudianteId);
    List<Entrega> findByTareaId(Long tareaId);
}

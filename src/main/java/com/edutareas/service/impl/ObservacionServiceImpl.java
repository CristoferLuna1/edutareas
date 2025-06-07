package com.edutareas.service.impl;

import com.edutareas.model.Observacion;
import com.edutareas.repository.ObservacionRepository;
import com.edutareas.service.ObservacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObservacionServiceImpl implements ObservacionService {

    private final ObservacionRepository observacionRepository;

    public ObservacionServiceImpl(ObservacionRepository observacionRepository) {
        this.observacionRepository = observacionRepository;
    }

    @Override
    public Observacion crearObservacion(Observacion observacion) {
        return observacionRepository.save(observacion);
    }

    @Override
    public Optional<Observacion> obtenerPorId(Long id) {
        return observacionRepository.findById(id);
    }

    @Override
    public List<Observacion> listarTodas() {
        return observacionRepository.findAll();
    }

    @Override
    public List<Observacion> listarPorEstudiante(Long estudianteId) {
        return observacionRepository.findByEstudianteId(estudianteId);
    }

    @Override
    public List<Observacion> listarPorDocente(Long docenteId) {
        return observacionRepository.findByDocenteId(docenteId);
    }

    @Override
    public void eliminarObservacion(Long id) {
        observacionRepository.deleteById(id);
    }
}

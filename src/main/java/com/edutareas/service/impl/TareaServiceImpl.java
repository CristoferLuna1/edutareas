package com.edutareas.service.impl;

import com.edutareas.model.Tarea;
import com.edutareas.repository.TareaRepository;
import com.edutareas.service.TareaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareaRepository;

    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Optional<Tarea> obtenerPorId(Long id) {
        return tareaRepository.findById(id);
    }

    @Override
    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    @Override
    public List<Tarea> listarPorCurso(Long cursoId) {
        return tareaRepository.findByCursoId(cursoId);
    }

    @Override
    public List<Tarea> listarPorDocente(Long docenteId) {
        return tareaRepository.findByDocenteId(docenteId);
    }

    @Override
    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}

package com.edutareas.controller;

import com.edutareas.model.Tarea;
import com.edutareas.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    public ResponseEntity<Tarea> crear(@RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.crearTarea(tarea));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtener(@PathVariable Long id) {
        return tareaService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Tarea> listarTodas() {
        return tareaService.listarTodas();
    }

    @GetMapping("/curso/{cursoId}")
    public List<Tarea> listarPorCurso(@PathVariable Long cursoId) {
        return tareaService.listarPorCurso(cursoId);
    }

    @GetMapping("/docente/{docenteId}")
    public List<Tarea> listarPorDocente(@PathVariable Long docenteId) {
        return tareaService.listarPorDocente(docenteId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }
}

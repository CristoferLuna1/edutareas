package com.edutareas.controller;

import com.edutareas.model.Observacion;
import com.edutareas.service.ObservacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/observaciones")
public class ObservacionController {

    private final ObservacionService observacionService;

    public ObservacionController(ObservacionService observacionService) {
        this.observacionService = observacionService;
    }

    @PostMapping
    public ResponseEntity<Observacion> crear(@RequestBody Observacion observacion) {
        return ResponseEntity.ok(observacionService.crearObservacion(observacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Observacion> obtener(@PathVariable Long id) {
        return observacionService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Observacion> listarTodas() {
        return observacionService.listarTodas();
    }

    @GetMapping("/estudiante/{estudianteId}")
    public List<Observacion> listarPorEstudiante(@PathVariable Long estudianteId) {
        return observacionService.listarPorEstudiante(estudianteId);
    }

    @GetMapping("/docente/{docenteId}")
    public List<Observacion> listarPorDocente(@PathVariable Long docenteId) {
        return observacionService.listarPorDocente(docenteId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        observacionService.eliminarObservacion(id);
        return ResponseEntity.noContent().build();
    }
}

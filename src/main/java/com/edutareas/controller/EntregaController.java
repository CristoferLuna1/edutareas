package com.edutareas.controller;

import com.edutareas.model.Entrega;
import com.edutareas.service.EntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @PostMapping
    public ResponseEntity<Entrega> crear(@RequestBody Entrega entrega) {
        return ResponseEntity.ok(entregaService.crearEntrega(entrega));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> obtener(@PathVariable Long id) {
        return entregaService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Entrega> listarTodas() {
        return entregaService.listarTodas();
    }

    @GetMapping("/estudiante/{estudianteId}")
    public List<Entrega> listarPorEstudiante(@PathVariable Long estudianteId) {
        return entregaService.listarPorEstudiante(estudianteId);
    }

    @GetMapping("/tarea/{tareaId}")
    public List<Entrega> listarPorTarea(@PathVariable Long tareaId) {
        return entregaService.listarPorTarea(tareaId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        entregaService.eliminarEntrega(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
public ResponseEntity<Entrega> calificar(@PathVariable Long id, @RequestBody Map<String, Double> body) {
    return entregaService.obtenerPorId(id)
        .map(entrega -> {
            entrega.setCalificacion(body.get("calificacion"));
            return ResponseEntity.ok(entregaService.crearEntrega(entrega));
        })
        .orElse(ResponseEntity.notFound().build());
}

}

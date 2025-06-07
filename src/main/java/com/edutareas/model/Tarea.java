package com.edutareas.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private LocalDate fechaLimite;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Usuario docente;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}

package com.gestion_estudiantes.gestion_estudiantes.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "estudiantes")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String nombre;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "estudiante_curso", // Tabla intermedia
            joinColumns = @JoinColumn(name = "estudiante_id"), // FK de estudiante
            inverseJoinColumns = @JoinColumn(name = "curso_id") // FK de curso
    )
    private List<Curso> cursos;

}

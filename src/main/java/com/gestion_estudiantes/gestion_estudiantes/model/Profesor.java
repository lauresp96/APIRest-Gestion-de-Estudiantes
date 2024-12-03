package com.gestion_estudiantes.gestion_estudiantes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "profesores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String nombre;
    private String email;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;

}

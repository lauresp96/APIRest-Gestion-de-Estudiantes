package com.gestion_estudiantes.gestion_estudiantes.repositories;

import com.gestion_estudiantes.gestion_estudiantes.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}

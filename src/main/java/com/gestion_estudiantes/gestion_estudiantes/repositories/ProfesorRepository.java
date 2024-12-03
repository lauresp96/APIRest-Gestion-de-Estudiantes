package com.gestion_estudiantes.gestion_estudiantes.repositories;

import com.gestion_estudiantes.gestion_estudiantes.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}

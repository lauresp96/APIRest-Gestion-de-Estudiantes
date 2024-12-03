package com.gestion_estudiantes.gestion_estudiantes.service;

import com.gestion_estudiantes.gestion_estudiantes.model.Profesor;
import com.gestion_estudiantes.gestion_estudiantes.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;


    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> encontrarProfesorPorId(Long id) {
        return profesorRepository.findById(id);
    }

    public Profesor guardarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public void eliminarProfesor(long id) {
        profesorRepository.deleteById(id);
    }
}

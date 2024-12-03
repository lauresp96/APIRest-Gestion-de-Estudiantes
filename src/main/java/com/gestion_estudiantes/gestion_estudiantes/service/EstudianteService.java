package com.gestion_estudiantes.gestion_estudiantes.service;

import com.gestion_estudiantes.gestion_estudiantes.model.Estudiante;
import com.gestion_estudiantes.gestion_estudiantes.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;


    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> encontrarPorId(Long id) {
        return estudianteRepository.findById(id);
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiantes(Long id) {
        estudianteRepository.deleteById(id);
    }
}

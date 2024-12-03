package com.gestion_estudiantes.gestion_estudiantes.service;

import com.gestion_estudiantes.gestion_estudiantes.model.Curso;
import com.gestion_estudiantes.gestion_estudiantes.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;


    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> encontrarCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}

package com.gestion_estudiantes.gestion_estudiantes.service;

import com.gestion_estudiantes.gestion_estudiantes.model.Curso;
import com.gestion_estudiantes.gestion_estudiantes.model.Estudiante;
import com.gestion_estudiantes.gestion_estudiantes.repositories.CursoRepository;
import com.gestion_estudiantes.gestion_estudiantes.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;


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

    public void agregarEstudiante(Long id, Long estudianteId) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(estudianteId);

        if (cursoOptional.isPresent() && estudianteOptional.isPresent()){
            Curso curso = cursoOptional.get();
            Estudiante estudiante = estudianteOptional.get();

            if (!curso.getEstudiantes().contains(estudiante)){
                curso.getEstudiantes().add(estudiante);
                cursoRepository.save(curso);
            }
        }
    }
}

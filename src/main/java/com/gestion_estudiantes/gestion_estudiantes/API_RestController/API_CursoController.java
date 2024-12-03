package com.gestion_estudiantes.gestion_estudiantes.API_RestController;


import com.gestion_estudiantes.gestion_estudiantes.model.Curso;
import com.gestion_estudiantes.gestion_estudiantes.model.Estudiante;
import com.gestion_estudiantes.gestion_estudiantes.service.CursoService;
import com.gestion_estudiantes.gestion_estudiantes.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class API_CursoController {

    @Autowired
    private CursoService cursoService;


    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoService.listarCursos();
        return ResponseEntity.ok(cursos);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Curso> guardarCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.guardarCurso(curso);
        return ResponseEntity.ok(curso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> encontrarCursoPorId(@PathVariable Long id) {
        Optional<Curso> curso = cursoService.encontrarCursoPorId(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCurso(@PathVariable Long id) {
         cursoService.eliminarCurso(id);
        return ResponseEntity.ok("Curso eliminado con exito!");
    }
}

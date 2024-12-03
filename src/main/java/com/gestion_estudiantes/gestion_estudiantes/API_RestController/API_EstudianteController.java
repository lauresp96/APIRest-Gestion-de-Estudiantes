package com.gestion_estudiantes.gestion_estudiantes.API_RestController;


import com.gestion_estudiantes.gestion_estudiantes.model.Estudiante;
import com.gestion_estudiantes.gestion_estudiantes.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class API_EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.listarEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.guardarEstudiante(estudiante);
        return ResponseEntity.ok(estudiante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> encontrarEstudiantePorId(@PathVariable Long id) {
        Optional<Estudiante> estudiante = estudianteService.encontrarPorId(id);
        return estudiante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable Long id) {
         estudianteService.eliminarEstudiantes(id);
        return ResponseEntity.ok("Estudiante eliminado con exito!");
    }

}

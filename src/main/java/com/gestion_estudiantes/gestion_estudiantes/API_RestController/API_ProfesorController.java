package com.gestion_estudiantes.gestion_estudiantes.API_RestController;


import com.gestion_estudiantes.gestion_estudiantes.model.Profesor;
import com.gestion_estudiantes.gestion_estudiantes.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class API_ProfesorController {

    @Autowired
    private ProfesorService profesorService;


    @GetMapping
    public ResponseEntity<List<Profesor>> listarProfesores() {
        List<Profesor> profesores = profesorService.listarProfesores();
        return ResponseEntity.ok(profesores);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Profesor> guardarProfesor(@RequestBody Profesor profesor) {
        Profesor nuevoProfesor = profesorService.guardarProfesor(profesor);
        return ResponseEntity.ok(profesor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> encontrarProfesorPorId(@PathVariable Long id) {
        Optional<Profesor> profesor = profesorService.encontrarProfesorPorId(id);
        return profesor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable Long id) {
         profesorService.eliminarProfesor(id);
        return ResponseEntity.ok("Profesor eliminado con exito!");
    }

}

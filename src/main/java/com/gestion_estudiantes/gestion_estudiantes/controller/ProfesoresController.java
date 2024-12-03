package com.gestion_estudiantes.gestion_estudiantes.controller;

import com.gestion_estudiantes.gestion_estudiantes.model.Profesor;
import com.gestion_estudiantes.gestion_estudiantes.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/profesores")
public class ProfesoresController {

    @Autowired
    private ProfesorService profesorService;


    @GetMapping
    public String listarProfesores(Model model) {
        model.addAttribute("profesores", profesorService.listarProfesores());
        return "profesores";
    }

    @GetMapping("/nuevo")
    public String creacionProfesores(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "formulario-profesores";
    }

    @PostMapping("/guardar")
    public String guardarProfesor(@ModelAttribute Profesor profesor) {
        profesorService.guardarProfesor(profesor);
        return "redirect:/profesores";
    }

    @GetMapping("/editar/{id}")
    public String editarProfesor(@PathVariable Long id, Model model) {
        Optional<Profesor> profesor = profesorService.encontrarProfesorPorId(id);
        model.addAttribute("profesor", profesor);
        return "formulario-profesor";
    }

    @GetMapping("/eliminar{id}")
    public String eliminarProfesor(@PathVariable Long id) {
        profesorService.eliminarProfesor(id);
        return "redirect:/profesores";
    }
}

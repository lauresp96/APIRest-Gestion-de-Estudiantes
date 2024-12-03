package com.gestion_estudiantes.gestion_estudiantes.controller;


import com.gestion_estudiantes.gestion_estudiantes.model.Curso;
import com.gestion_estudiantes.gestion_estudiantes.model.Estudiante;
import com.gestion_estudiantes.gestion_estudiantes.service.CursoService;
import com.gestion_estudiantes.gestion_estudiantes.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listaEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.listarEstudiantes());
        return "estudiantes";
    }

    @GetMapping("/nuevo")
    public String formularioCrearEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "formulario-estudiantes";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String formularioEdicion(@PathVariable Long id, Model model) {
        Optional<Estudiante> estudiante = estudianteService.encontrarPorId(id);
        model.addAttribute("estudiante", estudiante);
        return "formulario-estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiantes(id);
        return "redirect:/estudiantes";
    }

    @GetMapping("/{id}/cursos")
    public String obtenerCursosDeEstudiante(@PathVariable Long id, Model model) {
        Optional<Estudiante> estudianteOpt = estudianteService.encontrarPorId(id);

        if (estudianteOpt.isPresent()) {
            Estudiante estudiante = estudianteOpt.get();
            model.addAttribute("estudiante", estudiante);
            model.addAttribute("cursos", estudiante.getCursos());
            return "cursos_estudiantes";
        } else {
            return "redirect:/estudiantes";
        }
    }
}

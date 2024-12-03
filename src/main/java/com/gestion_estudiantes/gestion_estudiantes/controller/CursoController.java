package com.gestion_estudiantes.gestion_estudiantes.controller;

import com.gestion_estudiantes.gestion_estudiantes.model.Curso;
import com.gestion_estudiantes.gestion_estudiantes.model.Estudiante;
import com.gestion_estudiantes.gestion_estudiantes.service.CursoService;
import com.gestion_estudiantes.gestion_estudiantes.service.EstudianteService;
import com.gestion_estudiantes.gestion_estudiantes.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ProfesorService profesorService;
    @Autowired

    private EstudianteService estudianteService;

    @GetMapping
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursoService.listarCursos());
        return "cursos";
    }

    @GetMapping("/nuevo")
    public String fomularioCreacionCurso(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("profesores", profesorService.listarProfesores());
        return "formulario-cursos";
    }

    @PostMapping("/guardar")
    public String guardarCurso(@ModelAttribute Curso curso) {
        cursoService.guardarCurso(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String editarCurso(@PathVariable Long id, Model model) {
        Optional<Curso> curso = cursoService.encontrarCursoPorId(id);
        model.addAttribute("curso", curso);
        model.addAttribute("profesores", profesorService.listarProfesores());
        return "formulario-cursos";
    }

    @GetMapping("/elimninar/{id}")
    public String eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return "redirect:/cursos";
    }

    @GetMapping("/{id}/agregar-estudiante")
    public String formularioAgregarEstudiante(@PathVariable Long id, Model model) {
        Optional<Curso> curso = cursoService.encontrarCursoPorId(id);
        if (curso.isPresent()) {
            model.addAttribute("curso", curso.get());
            model.addAttribute("estudiantes", estudianteService.listarEstudiantes());
            return "formulario-agregar-estudiante";
        } else {
            return "redirect:/cursos";
        }
    }

    @PostMapping("/{id}/agregar-estudiante")
    public String agregarEstudianteAlCurso(@PathVariable Long id, @RequestParam Long estudianteId) {
        cursoService.agregarEstudiante(id, estudianteId);
        return "redirect:/cursos";
    }
}

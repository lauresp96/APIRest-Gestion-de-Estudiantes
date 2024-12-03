# Sistema de Gestión de Estudiantes

Este proyecto es una aplicación de **gestión de estudiantes** para una escuela o universidad, desarrollada en Java con Spring Boot. Permite gestionar estudiantes, cursos y profesores, incluyendo funcionalidades de CRUD y asociaciones entre los distintos componentes.

## Características

- **Gestión de Estudiantes**: CRUD completo para estudiantes.
- **Gestión de Cursos**: CRUD completo para cursos, con asignación de profesores y estudiantes.
- **Gestión de Profesores**: CRUD completo para profesores.
- **Relaciones**: Los estudiantes pueden estar asociados a varios cursos, y los cursos a varios estudiantes.
- **API RESTful**: Exposición de los datos a través de una API RESTful para integrar con otros sistemas.

## Tecnologías Utilizadas

- **Java 17** (LTS)
- **Spring Boot**: Framework para desarrollo web y API RESTful.
- **Spring Data JPA**: Para la gestión de base de datos.
- **H2 Database**: Base de datos en memoria para desarrollo.
- **Thymeleaf**: Motor de plantillas para vistas web.
- **Postman**: Herramienta para interactuar con la API RESTful.

package org.example;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("db/alumnos.odb");

        //insertarAlumnosPrueba();

        CRUD.listarTodo();
        System.out.println("-----------------------------------------");
        CRUD.listarSuspensos();
        System.out.println("-----------------------------------------");
        CRUD.estadisticas();
    }

    public static void insertarAlumnosPrueba(){
        Alumno alumno = new Alumno();
        alumno.setNombre("Pablo");
        alumno.setTelefono("666666666");
        alumno.setEmail("pablo@gmail.com");
        alumno.setNotaAD(10.0);
        alumno.setNotaDI(10.0);
        CRUD.insertarAlumno(alumno);

        alumno.setId(2L);
        alumno.setNombre("Miguel");
        alumno.setTelefono("664936393");
        alumno.setEmail("pepe@gmail.com");
        alumno.setNotaAD(8.0);
        alumno.setNotaDI(4.0);
        CRUD.insertarAlumno(alumno);

        alumno.setId(3L);
        alumno.setNombre("Koke");
        alumno.setTelefono("666226666");
        alumno.setEmail("pepe@gmail.com");
        alumno.setNotaAD(5.0);
        alumno.setNotaDI(5.0);
        CRUD.insertarAlumno(alumno);

        alumno.setId(4L);
        alumno.setNombre("Loren");
        alumno.setTelefono("69966996");
        alumno.setEmail("pepe@gmail.com");
        alumno.setNotaAD(2.0);
        alumno.setNotaDI(9.0);
        CRUD.insertarAlumno(alumno);

        alumno.setId(5L);
        alumno.setNombre("Luis");
        alumno.setTelefono("666666666");
        alumno.setEmail("pepe@gmail.com");
        alumno.setNotaAD(0.5);
        alumno.setNotaDI(2.3);
        CRUD.insertarAlumno(alumno);
    }
}
package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.text.DecimalFormat;

import static org.example.Main.emf;

public class CRUD {

    public static void insertarAlumno(Alumno alumno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();
    }

    public static void listarTodo() {

        System.out.println("Lista de todos los alumnos:");
        System.out.println();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a", Alumno.class);
        for (Alumno alumno : query.getResultList()) {
            System.out.println("Alumno{" +
                    "id=" + alumno.getId() +
                    ", nombre='" + alumno.getNombre() + '\'' +
                    ", telefono='" + alumno.getTelefono() + '\'' +
                    ", email='" + alumno.getEmail() + '\'' +
                    ", notaAD=" + alumno.getNotaAD() +
                    ", notaDI=" + alumno.getNotaDI() +
                    "}");
        }
        em.close();
    }

    public static void listarSuspensos() {

        System.out.println("Lista de alumnos suspensos:");
        System.out.println("Saldrán solo las asignaturas que ha suspendido");
        System.out.println();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a WHERE a.notaAD < 5 OR a.notaDI < 5", Alumno.class);
        for (Alumno alumno : query.getResultList()) {
            if (alumno.getNotaAD() < 5.0 && alumno.getNotaDI() >= 5.0){
                System.out.println("Alumno{" +
                        "id=" + alumno.getId() +
                        ", nombre='" + alumno.getNombre() + '\'' +
                        ", notaAD=" + alumno.getNotaAD() +
                        "}");
            } else if (alumno.getNotaDI() < 5.0 && alumno.getNotaAD() >= 5.0){
                System.out.println("Alumno{" +
                        "id=" + alumno.getId() +
                        ", nombre='" + alumno.getNombre() + '\'' +
                        ", notaDI=" + alumno.getNotaDI() +
                        "}");
            } else {
                System.out.println("Alumno{" +
                        "id=" + alumno.getId() +
                        ", nombre='" + alumno.getNombre() + '\'' +
                        ", notaAD=" + alumno.getNotaAD() +
                        ", notaDI=" + alumno.getNotaDI() +
                        "}");
            }
        }
        em.close();
    }

    public static void estadisticas() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a", Alumno.class);
        Double notaAD = 0.0;
        Double notaDI = 0.0;
        Double aprobados = 0.0;

        for (Alumno alumno : query.getResultList()) {
            notaAD += alumno.getNotaAD();
            notaDI += alumno.getNotaDI();
            if (alumno.getNotaAD() >= 5.0 && alumno.getNotaDI() >= 5.0){
                aprobados++;
            }

        }

        notaAD = notaAD / query.getResultList().size();
        notaDI = notaDI / query.getResultList().size();
        aprobados = (aprobados / query.getResultList().size())*100;


        //Esto es para que solo muestre 2 decimales
        String pattern = "#.##";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        String notaADs = decimalFormat.format(notaAD);
        String notaDIs = decimalFormat.format(notaDI);
        String aprobadosString = decimalFormat.format(aprobados);


        System.out.println("Nota media en Acceso a Datos: " + notaADs);
        System.out.println("Nota media en Desarrollo de Interfaces: " + notaDIs);
        System.out.println("Porcentaje de alumnos sin ningún suspenso: " + aprobadosString + "%");

        em.close();
    }
}

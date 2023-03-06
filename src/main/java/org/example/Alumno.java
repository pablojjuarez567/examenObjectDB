package org.example;


import lombok.Data;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.*;

@Data
@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String telefono;
    String email;
    Double notaAD;
    Double notaDI;

}

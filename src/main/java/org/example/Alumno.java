package org.example;


import lombok.Data;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.*;

@Data
@Entity
public class Alumno {

    @Id
    Long id;
    @Basic
    String nombre;
    @Basic
    String telefono;
    @Basic
    String email;
    @Basic
    Double notaAD;
    @Basic
    Double notaDI;

}

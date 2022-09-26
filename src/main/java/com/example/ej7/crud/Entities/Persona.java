package com.example.ej7.crud.Entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

@Data //Lombok hace constructor por defecto y getters y setters
@Entity //Indicamos a JPA que esta clase es una entidad
@Table(name="persona") //Indicamos a JPA a que tabla apunta esta entidad
public class Persona implements java.io.Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Rellene el campo nombre") //Incluye @NotNull
    @Column
    private String nombre;

    @NotNull //No lo coge si el tipo no es Integer!!!!!
    @Min(value = 0, message = "La edad tiene que ser 0 o más")
    @Max(value = 120, message = "La edad tiene que ser menor de 120")
    @Column
    private Integer edad;

    @NotBlank(message = "Rellene el campo poblacion")
    @Column
    private String poblacion;
}

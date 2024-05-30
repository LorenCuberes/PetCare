package com.conexion.petcarec.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "persona")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Persona {
    @Id
    @Column(name = "idpersona", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "fechadenacimiento")
    private LocalDate fechadenacimiento;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddireccion")
    private Direccion iddireccion;


}
package com.conexion.petcarec.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipodeusuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tipodeusuario {
    @Id
    @Column(name = "idtipousuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "denominacion", nullable = false, length = 100)
    private String denominacion;

}
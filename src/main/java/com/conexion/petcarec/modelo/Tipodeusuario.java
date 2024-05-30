package com.conexion.petcarec.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Integer id;

    @Column(name = "denominacion", nullable = false, length = 100)
    private String denominacion;

}
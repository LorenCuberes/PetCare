package com.conexion.petcarec.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "raza")
public class Raza {
    @Id
    @Column(name = "idraza", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

}
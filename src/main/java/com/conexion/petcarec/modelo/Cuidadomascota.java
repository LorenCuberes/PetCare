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
@Table(name = "cuidadomascota")
public class Cuidadomascota {
    @Id
    @Column(name = "idcuidado", nullable = false)
    private Integer id;

    @Column(name = "dieta", nullable = false, length = 200)
    private String dieta;

    @Column(name = "cuidado", nullable = false, length = 200)
    private String cuidado;

}
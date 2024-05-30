package com.conexion.petcarec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clinicaveterinaria")
public class Clinicaveterinaria {
    @Id
    @Column(name = "idclinica", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddireccion")
    private Direccion iddireccion;

}
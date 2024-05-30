package com.conexion.petcarec.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "consentimiento")
public class Consentimiento {
    @Id
    @Column(name = "idconsentimiento", nullable = false)
    private Integer id;

    @Column(name = "terminosycondiciones", length = 100)
    private String terminosycondiciones;

    @Column(name = "firma", nullable = false, length = 300)
    private String firma;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

}
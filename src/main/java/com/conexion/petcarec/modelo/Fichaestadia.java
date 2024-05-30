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
@Table(name = "fichaestadia")
public class Fichaestadia {
    @Id
    @Column(name = "idficha", nullable = false)
    private Integer id;

    @Column(name = "fechaingresa", nullable = false)
    private LocalDate fechaingresa;

    @Column(name = "fechaegreso")
    private LocalDate fechaegreso;

}
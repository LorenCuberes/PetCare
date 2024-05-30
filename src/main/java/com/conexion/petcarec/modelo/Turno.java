package com.conexion.petcarec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "turno")
public class Turno {
    @Id
    @Column(name = "idturno", nullable = false)
    private Integer id;

    @Column(name = "fechaturno", nullable = false)
    private LocalDate fechaturno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idservicio", nullable = false)
    private Tiposervicio idservicio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idmascota", nullable = false)
    private Mascota idmascota;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idestado", nullable = false)
    private Estadoturno idestado;

    @Column(name = "horarioturno", nullable = false)
    private LocalTime horarioturno;

}
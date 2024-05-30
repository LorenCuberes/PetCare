package com.conexion.petcarec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @Column(name = "idpedido", nullable = false)
    private Integer id;

    @Column(name = "fechapedido", nullable = false)
    private LocalDate fechapedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente idcliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idestado", nullable = false)
    private Estadopedido idestado;

}
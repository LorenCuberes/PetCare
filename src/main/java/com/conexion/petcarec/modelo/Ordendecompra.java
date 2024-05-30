package com.conexion.petcarec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ordendecompra")
public class Ordendecompra {
    @Id
    @Column(name = "idordencompra", nullable = false)
    private Integer id;

    @Column(name = "fechaoc", nullable = false)
    private LocalDate fechaoc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iddetalleorden", nullable = false)
    private Detalledeordendecompra iddetalleorden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproveedor")
    private Proveedor idproveedor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idestado", nullable = false)
    private Estadopedido idestado;

}
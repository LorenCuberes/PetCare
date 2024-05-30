package com.conexion.petcarec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalledeordendecompra")
public class Detalledeordendecompra {
    @Id
    @Column(name = "iddetalledeorden", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idproducto", nullable = false)
    private Producto idproducto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

}
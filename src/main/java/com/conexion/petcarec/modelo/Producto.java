package com.conexion.petcarec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "idproducto", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcategoria", nullable = false)
    private Categoriaproducto idcategoria;

}
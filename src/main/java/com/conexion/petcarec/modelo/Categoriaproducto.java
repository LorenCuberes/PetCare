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
@Table(name = "categoriaproducto")
public class Categoriaproducto {
    @Id
    @Column(name = "idcategoria", nullable = false)
    private Integer id;

    @Column(name = "nombrecategoria", nullable = false, length = 100)
    private String nombrecategoria;

}
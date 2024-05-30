package com.conexion.petcarec.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "provincia")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Provincia {
    @Id
    @Column(name = "idprovincia", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idpais", nullable = false)
    private Pais idpais;

}
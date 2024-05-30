package com.conexion.petcarec.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "localidad")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Localidad {
    @Id
    @Column(name = "idlocalidad", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idprovincia", nullable = false)
    private Provincia idprovincia;

}
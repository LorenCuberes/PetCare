package com.conexion.petcarec.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "direccion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Direccion {
    @Id
    @Column(name = "iddireccion", nullable = false)
    private Integer id;

    @Column(name = "calle", nullable = false, length = 100)
    private String calle;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "departamento", length = 10)
    private String departamento;

    @Column(name = "piso")
    private Integer piso;

    @Column(name = "barrio", length = 100)
    private String barrio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idlocalidad", nullable = false)
    private Localidad idlocalidad;

}
package com.conexion.petcarec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tiposervicio")
public class Tiposervicio {
    @Id
    @Column(name = "idservicio", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 300)
    private String descripcion;

    @Column(name = "costounitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal costounitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idveterinario")
    private Veterinario idveterinario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idconsentimiento")
    private Consentimiento idconsentimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipodetrabajo")
    private Tipotrabajopeluqueria idtipodetrabajo;

}
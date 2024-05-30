package com.conexion.petcarec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "veterinario")
public class Veterinario {
    @Id
    @Column(name = "idveterinario", nullable = false)
    private Integer id;

    @Column(name = "matricula", length = 50)
    private String matricula;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idclinica", nullable = false)
    private Clinicaveterinaria idclinica;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idpersona", nullable = false)
    private Persona idpersona;

}
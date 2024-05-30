package com.conexion.petcarec.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @Column(name = "idproveedor", nullable = false)
    private Integer id;

    @Column(name = "nombreempresa", nullable = false, length = 100)
    private String nombreempresa;

    @Column(name = "numdocumento", length = 50)
    private String numdocumento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idpersona", nullable = false)
    private Persona idpersona;

}
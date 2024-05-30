package com.conexion.petcarec.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {
    @Id
    @Column(name = "idusuario", nullable = false)
    private Integer id;

    @Column(name = "contrasena", nullable = false, length = 100)
    private String contrasena;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idpersona", nullable = false)
    private Persona idpersona;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idtipousuario", nullable = false)
    private Tipodeusuario idtipousuario;


    @Column(name = "estado", nullable = false)
    private Character estado;

}